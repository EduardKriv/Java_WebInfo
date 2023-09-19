package krived.web.info.controller;

import jakarta.servlet.http.HttpServletResponse;
import krived.web.info.mapper.GenericMapper;
import krived.web.info.model.dto.BaseDto;
import krived.web.info.model.entity.BaseEntity;
import krived.web.info.service.GenericService;
import krived.web.info.utility.CsvConverter;
import krived.web.info.utility.DtoMetaData;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public abstract class GenericController<E extends BaseEntity<T>, D extends BaseDto, T extends Comparable<T>>  {
    protected final GenericService<E, T> genericService;
    protected final GenericMapper<E, D> genericMapper;
    private final Class<D> clazz;

    @GetMapping("all")
    public String all(@NotNull Model model) {
        List<D> dtos = genericMapper.toDtos(genericService.getAll().stream()
                                                .sorted(Comparator.comparing(BaseEntity::getId))
                                                .toList());

        model.addAttribute("columnNames", DtoMetaData.getColumnNames(clazz));
        model.addAttribute("tableName", DtoMetaData.getClassName(clazz));
        model.addAttribute("modelList", dtos);

        return "data_table";
    }

    @ResponseBody
    @GetMapping("all_id")
    public List<T> allId() {
        return genericService.getAll().stream().map(BaseEntity::getId).toList();
    }

    @PostMapping("add")
    public String create(Model model, @ModelAttribute("Model") @NotNull D dto) {
        genericService.create(genericMapper.toEntity(dto));
        return setResponseStatusAndMessage(model, "Success", "Запись добавлена");
    }

    @PostMapping("update")
    public String update(Model model, @ModelAttribute("Model") @NotNull D dto, @RequestParam T id) {
        E entity = genericService.getById(id);
        genericMapper.updateEntityFromDto(dto, entity);
        genericService.update(entity);
        return setResponseStatusAndMessage(model, "Success", "Запись обновлена");
    }

    @PostMapping("delete")
    public String remove(Model model, @ModelAttribute("Model") @NotNull D dto) {
        genericService.delete(genericMapper.toEntity(dto));
        return setResponseStatusAndMessage(model, "Success", "Запись удалена");
    }

    @PostMapping("upload")
    public String upload(Model model, @RequestParam("file") MultipartFile file) {
        try {
            List<D> dtos = CsvConverter.upload(file, clazz);
            genericService.saveAll(genericMapper.toEntities(dtos));
            return setResponseStatusAndMessage(model, "Success", "Файл успешно загружен");
        } catch (Exception e) {
            return setResponseStatusAndMessage(model, "Failure", "Ошибка загрузки файла");
        }
    }

    @GetMapping("unload")
    public void unload(@NotNull HttpServletResponse servletResponse) throws IOException {
        String fileName = DtoMetaData.getClassName(clazz);
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + ".csv\"");
        List<D> beans = genericMapper.toDtos(genericService.getAll());
        CsvConverter.unload(servletResponse.getWriter(), beans, clazz);
    }

    protected String setResponseStatusAndMessage(Model model, String status, String message) {
        model.addAttribute("status", status);
        model.addAttribute("message", message);
        return all(model);
    }
}
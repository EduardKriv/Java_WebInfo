package krived.web.info.controller;

import jakarta.servlet.http.HttpServletResponse;
import krived.web.info.mapper.GenericMapper;
import krived.web.info.model.dto.CsvBean;
import krived.web.info.model.entity.BaseEntity;
import krived.web.info.service.GenericService;
import krived.web.info.utility.CsvConverter;
import krived.web.info.utility.DtoMetaData;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public abstract class GenericController<E extends BaseEntity, D extends CsvBean, T> {
    private final GenericService<E, T> genericService;
    private final GenericMapper<E, D> genericMapper;

    @GetMapping("/all")
    public String allPeers(@NotNull Model model) {
        List<D> dtos = genericMapper.toDtos(genericService.getAll());
        model.addAttribute("columnNames", DtoMetaData.getColumnNames(getClazz()));
        model.addAttribute("tableName", DtoMetaData.getClassName(getClazz()));
        model.addAttribute("allPeers", dtos);
        return "index";
    }

    @PostMapping("add")
    public String create(@ModelAttribute("addedPeer") @NotNull D dto) {
//        genericService.create(genericMapper.toEntity(dto));
        return "redirect:all";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("updatedPeer") @NotNull D dto) {
//        genericService.update(genericMapper.toEntity(dto));
        return "redirect:all";
    }

    @PostMapping("delete")
    public String remove(@ModelAttribute("deletedPeer") @NotNull D dto) {
        genericService.delete(genericMapper.toEntity(dto));
        return "redirect:all";
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        List<D> dtos = CsvConverter.upload(file, getClazz());
        genericService.saveAll(genericMapper.toEntities(dtos));
        return "redirect:all";
    }

    @GetMapping("unload")
    public void unload(@NotNull HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"peers.csv\"");
        List<D> beans = genericMapper.toDtos(genericService.getAll());
        CsvConverter.unload(servletResponse.getWriter(), beans, getClazz());
    }

    protected abstract Class<D> getClazz();
}

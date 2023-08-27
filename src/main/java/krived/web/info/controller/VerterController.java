package krived.web.info.controller;

import jakarta.servlet.http.HttpServletResponse;
import krived.web.info.mapper.VerterMapper;
import krived.web.info.model.dto.VerterDto;
import krived.web.info.model.entity.Verter;
import krived.web.info.utility.CsvConverter;
import krived.web.info.service.VerterService;
import krived.web.info.utility.DtoMetaData;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/verter")
public class VerterController {
    private final VerterService verterService;
    private final VerterMapper verterMapper;

    @GetMapping("/all")
    public String allVerters(Model model) {
        List<VerterDto> vertersDtos = verterMapper.toDtos(verterService.getAll());

        model.addAttribute("columnNames", DtoMetaData.getColumnNames(VerterDto.class));
        model.addAttribute("tableName", "verter");
        model.addAttribute("allVerters", vertersDtos);
        return "index";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addedVerter") @NotNull VerterDto dto) {
        verterService.create(verterMapper.toEntity(dto));
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("updatedVerter") @NotNull VerterDto dto) {
        Verter verterEntity = verterService.getById(dto.getId());
        verterMapper.updateVerterFromDto(dto, verterEntity);
        verterService.update(verterEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String remove(@ModelAttribute("deletedVerter") @NotNull VerterDto dto) {
        Verter verterEntity = verterService.getById(dto.getId());
        verterService.delete(verterEntity);
        return "redirect:all";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        List<VerterDto> verterDtos = CsvConverter.upload(file, VerterDto.class);
        verterService.saveAll(verterMapper.toEntities(verterDtos));
        return "redirect:all";
    }

    @GetMapping("/unload")
    public void unload(@NotNull HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"verter.csv\"");
        List<VerterDto> beans = verterMapper.toDtos(verterService.getAll());
        CsvConverter.unload(servletResponse.getWriter(), beans, VerterDto.class);
    }
}

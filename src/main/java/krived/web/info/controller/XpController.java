package krived.web.info.controller;

import jakarta.servlet.http.HttpServletResponse;
import krived.web.info.mapper.XpMapper;
import krived.web.info.model.dto.XpDto;
import krived.web.info.model.entity.Xp;
import krived.web.info.utility.CsvConverter;
import krived.web.info.service.XpService;
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
@RequestMapping("/xp")
public class XpController {
    private final XpService xpService;
    private final XpMapper xpMapper;

    @GetMapping("/all")
    public String allXps(Model model) {
        List<XpDto> xpDtos = xpMapper.toDtos(xpService.getAll());

        model.addAttribute("columnNames", DtoMetaData.getColumnNames(XpDto.class));
        model.addAttribute("tableName", "xp");
        model.addAttribute("allXp", xpDtos);
        return "index";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addedXp") @NotNull XpDto dto) {
//        Xp xpEntity = xpMapper.toEntity(dto);
//        xpService.create(xpEntity);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("updatedXp") @NotNull XpDto dto) {
        Xp xpEntity = xpService.getById(dto.getId());
        xpMapper.updateXpFromDto(dto, xpEntity);
        xpService.update(xpEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String remove(@ModelAttribute("deletedXp") @NotNull XpDto dto) {
        Xp xpEntity = xpService.getById(dto.getId());
        xpService.delete(xpEntity);
        return "redirect:all";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        List<XpDto> xpDtos = CsvConverter.upload(file, XpDto.class);
        xpService.saveAll(xpMapper.toEntities(xpDtos));
        return "redirect:all";
    }

    @GetMapping("/unload")
    public void unload(@NotNull HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"xp.csv\"");
        List<XpDto> beans = xpMapper.toDtos(xpService.getAll());
        CsvConverter.unload(servletResponse.getWriter(), beans, XpDto.class);
    }
}

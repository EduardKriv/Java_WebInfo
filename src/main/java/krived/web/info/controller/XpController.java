package krived.web.info.controller;

import krived.web.info.mapper.XpMapper;
import krived.web.info.model.dto.XpDto;
import krived.web.info.model.entity.Xp;
import krived.web.info.service.XpService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/xp")
public class XpController {
    private final XpService xpService;
    private final XpMapper xpMapper;

    @GetMapping("/all")
    public String allXps(Model model) {
        List<Xp> xps = xpService.getAll();
        List<XpDto> xpDtos = xpMapper.toDtos(xps);
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
}

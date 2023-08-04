package krived.web.info.controller;

import krived.web.info.mapper.VerterMapper;
import krived.web.info.model.dto.VerterDto;
import krived.web.info.model.entity.Check;
import krived.web.info.model.entity.Verter;
import krived.web.info.service.VerterService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/verter")
public class VerterController {
    private final VerterService verterService;
    private final VerterMapper verterMapper;

    @GetMapping("/all")
    public String allVerters(Model model) {
        List<Verter> verters = verterService.getAll();
        List<VerterDto> vertersDtos = verterMapper.toDtos(verters);
        model.addAttribute("tableName", "verter");
        model.addAttribute("allVerters", vertersDtos);
        return "home";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addedVerter") @NotNull VerterDto dto) {
//        Verter verterEntity = verterMapper.toEntity(dto);

        VerterDto verter = new VerterDto();
        verter.setId(1L);
        verter.setCheck(3L);
        verter.setState("Succ");
        verter.setTime(LocalTime.now());
        verterService.create(verterMapper.toEntity(verter));

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
}

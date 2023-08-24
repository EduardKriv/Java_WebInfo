package krived.web.info.controller;

import krived.web.info.mapper.CheckMapper;
import krived.web.info.model.dto.CheckDto;
import krived.web.info.model.dto.PeerDto;
import krived.web.info.model.entity.Check;
import krived.web.info.service.CheckService;
import krived.web.info.service.ConvertCsvService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/check")
public class CheckController {
    private final CheckService checkService;
    private final CheckMapper checkMapper;

    @GetMapping("/all")
    public String allChecks(Model model) {
        List<Check> checks = checkService.getAll();
        List<CheckDto> checksDtos = checkMapper.toDtos(checks);
        model.addAttribute("tableName", "checks");
        model.addAttribute("allChecks", checksDtos);
        return "index";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addedCheck") @NotNull CheckDto dto) {
//        Check checkEntity = checkMapper.toEntity(dto);
//        checkService.create(checkEntity);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("updatedCheck") @NotNull CheckDto dto) {
        Check checkEntity = checkService.getById(dto.getId());
        checkMapper.updateCheckFromDto(dto, checkEntity);
        checkService.update(checkEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String remove(@ModelAttribute("deletedCheck") @NotNull CheckDto dto) {
        Check checkEntity = checkService.getById(dto.getId());
        checkService.delete(checkEntity);
        return "redirect:all";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        @SuppressWarnings("unchecked")
        List<CheckDto> checks = (List<CheckDto>) ConvertCsvService.upload(file, CheckDto.class);
        checkService.saveAll(checkMapper.toEntities(checks));
        return "redirect:all";
    }
}

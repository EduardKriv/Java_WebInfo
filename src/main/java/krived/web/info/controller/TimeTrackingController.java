package krived.web.info.controller;

import krived.web.info.mapper.TimeTrackingMapper;
import krived.web.info.model.dto.TimeTrackingDto;
import krived.web.info.model.entity.TimeTracking;
import krived.web.info.service.TimeTrackingService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/time_tracking")
public class TimeTrackingController {
    private final TimeTrackingService timeTrackingService;
    private final TimeTrackingMapper timeTrackingMapper;

    @GetMapping("/all")
    public String allTimeTrackings(Model model) {
        List<TimeTracking> timeTrackings = timeTrackingService.getAll();
        List<TimeTrackingDto> timeTrackingsDtos = timeTrackingMapper.toDtos(timeTrackings);
        model.addAttribute("tableName", "time_tracking");
        model.addAttribute("allTimeTracking", timeTrackingsDtos);
        return "index";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addedTimeTracking") @NotNull TimeTrackingDto dto) {
//        TimeTracking timeTrackingEntity = timeTrackingMapper.toEntity(dto);
//        timeTrackingService.create(timeTrackingEntity);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("updatedTimeTracking") @NotNull TimeTrackingDto dto) {
//        TimeTracking timeTrackingEntity = timeTrackingService.getById(dto.getId());
//        timeTrackingMapper.updateTimeTrackingFromDto(dto,] timeTrackingEntity);
//        timeTrackingService.update(timeTrackingEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String remove(@ModelAttribute("deletedTimeTracking") @NotNull TimeTrackingDto dto) {
        TimeTracking timeTrackingEntity = timeTrackingService.getById(dto.getId());
        timeTrackingService.delete(timeTrackingEntity);
        return "redirect:all";
    }
}

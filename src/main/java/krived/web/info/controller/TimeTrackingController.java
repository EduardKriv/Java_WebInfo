package krived.web.info.controller;

import jakarta.servlet.http.HttpServletResponse;
import krived.web.info.mapper.TimeTrackingMapper;
import krived.web.info.model.dto.TimeTrackingDto;
import krived.web.info.model.entity.TimeTracking;
import krived.web.info.utility.CsvConverter;
import krived.web.info.service.TimeTrackingService;
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
@RequestMapping("/time_tracking")
public class TimeTrackingController {
    private final TimeTrackingService timeTrackingService;
    private final TimeTrackingMapper timeTrackingMapper;

    @GetMapping("/all")
    public String allTimeTracking(Model model) {
        List<TimeTrackingDto> timeTrackingsDtos = timeTrackingMapper.toDtos(timeTrackingService.getAll());

        model.addAttribute("columnNames", DtoMetaData.getColumnNames(TimeTrackingDto.class));
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

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        List<TimeTrackingDto> timeTrackingDtos = CsvConverter.upload(file, TimeTrackingDto.class);
        timeTrackingService.saveAll(timeTrackingMapper.toEntities(timeTrackingDtos));
        return "redirect:all";
    }

    @GetMapping("/unload")
    public void unload(@NotNull HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"time_tracking.csv\"");
        List<TimeTrackingDto> beans = timeTrackingMapper.toDtos(timeTrackingService.getAll());
        CsvConverter.unload(servletResponse.getWriter(), beans, TimeTrackingDto.class);
    }
}

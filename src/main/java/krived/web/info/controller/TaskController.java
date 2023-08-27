package krived.web.info.controller;

import jakarta.servlet.http.HttpServletResponse;
import krived.web.info.mapper.TaskMapper;
import krived.web.info.model.dto.TaskDto;
import krived.web.info.model.entity.Task;
import krived.web.info.utility.CsvConverter;
import krived.web.info.service.TaskService;
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
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("/all")
    public String allTasks(Model model) {
        List<TaskDto> tasksDtos = taskMapper.toDtos(taskService.getAll());

        model.addAttribute("columnNames", DtoMetaData.getColumnNames(TaskDto.class));
        model.addAttribute("tableName", "tasks");
        model.addAttribute("allTasks", tasksDtos);
        return "index";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addedTask") @NotNull TaskDto dto) {
        Task taskEntity = taskMapper.toEntity(dto);
        taskService.create(taskEntity);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("updatedTask") @NotNull TaskDto dto) {
        Task taskEntity = taskService.getById(dto.getTitle());
        dto.setParentTask("C8_3DViewer_v1");
        taskMapper.updateTaskFromDto(dto, taskEntity);
        taskService.update(taskEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String remove(@ModelAttribute("deletedTask") @NotNull TaskDto dto) {
        Task taskEntity = taskService.getById(dto.getTitle());
        taskService.delete(taskEntity);
        return "redirect:all";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        List<TaskDto> tasksDto = CsvConverter.upload(file, TaskDto.class);
        tasksDto.forEach(task -> taskService.create(taskMapper.toEntity(task)));
        return "redirect:all";
    }

    @GetMapping("/unload")
    public void unload(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"tasks.csv\"");
        List<TaskDto> beans = taskMapper.toDtos(taskService.getAll());
        CsvConverter.unload(servletResponse.getWriter(), beans, TaskDto.class);
    }
}

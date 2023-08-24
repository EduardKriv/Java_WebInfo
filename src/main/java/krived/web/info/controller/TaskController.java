package krived.web.info.controller;

import krived.web.info.mapper.TaskMapper;
import krived.web.info.model.dto.PeerDto;
import krived.web.info.model.dto.TaskDto;
import krived.web.info.model.entity.Task;
import krived.web.info.service.ConvertCsvService;
import krived.web.info.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("/all")
    public String allTasks(Model model) {
        List<Task> tasks = taskService.getAll();
        List<TaskDto> tasksDtos = taskMapper.toDtos(tasks);
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
        @SuppressWarnings("unchecked")
        List<TaskDto> tasksDto = (List<TaskDto>) ConvertCsvService.upload(file, TaskDto.class);
        tasksDto.forEach(task -> taskService.create(taskMapper.toEntity(task)));
        return "redirect:all";
    }
}

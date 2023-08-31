package krived.web.info.controller;

import krived.web.info.mapper.TaskMapper;
import krived.web.info.model.dto.TaskDto;
import krived.web.info.model.entity.Task;
import krived.web.info.service.TaskService;
import krived.web.info.utility.CsvConverter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController extends GenericController<Task, TaskDto, String>{
    @Autowired
    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        super(taskService, taskMapper, TaskDto.class);
    }

    @Override
    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        List<TaskDto> tasksDto = CsvConverter.upload(file, TaskDto.class);
        tasksDto.forEach(task -> genericService.create(genericMapper.toEntity(task)));
        return "redirect:all";
    }

    @Override
    @PostMapping("update")
    public String update(@ModelAttribute("Model") @NotNull TaskDto dto, @RequestParam String title) {
        return super.update(dto, title);
    }
}

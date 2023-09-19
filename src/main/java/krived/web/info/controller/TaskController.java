package krived.web.info.controller;

import krived.web.info.mapper.TaskMapper;
import krived.web.info.model.dto.TaskDto;
import krived.web.info.model.entity.Task;
import krived.web.info.service.TaskService;
import krived.web.info.utility.CsvConverter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String upload(Model model, @RequestParam("file") @NotNull MultipartFile file) {
        try {
            List<TaskDto> tasksDto = CsvConverter.upload(file, TaskDto.class);
            tasksDto.forEach(task -> genericService.create(genericMapper.toEntity(task)));
            return super.setResponseStatusAndMessage(model, "Success", "Файл успешно загружен");
        } catch (Exception e) {
            return super.setResponseStatusAndMessage(model, "Failure", "Ошибка загрузки файла");

        }
    }

    @Override
    @PostMapping("update")
    public String update(Model model, @ModelAttribute("Model") @NotNull TaskDto dto, @RequestParam String title) {
        return super.update(model, dto, title);
    }
}

package krived.web.info.controller;

import krived.web.info.mapper.TaskMapper;
import krived.web.info.model.dto.TaskDto;
import krived.web.info.model.entity.Task;
import krived.web.info.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController extends GenericController<Task, TaskDto, String>{
    @Autowired
    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        super(taskService, taskMapper);
    }

    @Override
    protected Class<TaskDto> getClazz() {
        return TaskDto.class;
    }
}

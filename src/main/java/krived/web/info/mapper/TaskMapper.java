package krived.web.info.mapper;

import krived.web.info.model.dto.TaskDto;
import krived.web.info.model.entity.Task;
import krived.web.info.service.TaskService;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class TaskMapper extends GenericMapper<Task, TaskDto> {
    @Autowired
    private TaskService taskService;

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract TaskDto toDto(Task task);

    public Task map(String task) {
        if (task == null || task.equals("NULL"))
            return null;
        return taskService.getById(task);
    }

    public String map(@NotNull Task task) {
        return task.getTitle();
    }
}


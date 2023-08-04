package krived.web.info.mapper;

import krived.web.info.model.dto.TaskDto;
import krived.web.info.model.entity.Task;
import krived.web.info.service.TaskService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public abstract class TaskMapper {
    @Autowired
    private TaskService taskService;

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract TaskDto toDto(Task task);
    public abstract Task toEntity(TaskDto task);
    public abstract List<TaskDto> toDtos(List<Task> tasks);
    public abstract List<Task> toEntities(List<TaskDto> tasks);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateTaskFromDto(TaskDto dto, @MappingTarget Task check);

    public Task map(String task) {
        return taskService.getById(task);
    }

    public String map(Task task) {
        return task.getTitle();
    }
}


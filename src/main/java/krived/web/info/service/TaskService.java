package krived.web.info.service;

import krived.web.info.model.entity.Task;
import krived.web.info.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(String title) {
        return taskRepository.getReferenceById(title);
    }

    public Task update(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    public Task create(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }
}

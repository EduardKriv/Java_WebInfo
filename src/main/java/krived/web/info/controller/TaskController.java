package krived.web.info.controller;

import krived.web.info.model.entity.Task;
import krived.web.info.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/all")
    public List<Task> allPeers() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable String id) {
        return taskRepository.findById(id).orElse(null);
    }
}

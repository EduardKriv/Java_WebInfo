package krived.web.info.repository;

import krived.web.info.model.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends GenericRepository<Task, String> {
}

package krived.web.info.repository;

import krived.web.info.model.entity.CallBody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<CallBody, Long> {
}

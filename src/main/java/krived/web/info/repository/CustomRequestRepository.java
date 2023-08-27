package krived.web.info.repository;

import krived.web.info.model.entity.CallBody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRequestRepository extends JpaRepository<CallBody, Long> {
}

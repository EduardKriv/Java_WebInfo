package krived.web.info.repository;

import krived.web.info.model.entity.Check;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<Check, Long> {
}

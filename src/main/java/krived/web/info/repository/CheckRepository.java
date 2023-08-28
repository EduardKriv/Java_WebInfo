package krived.web.info.repository;

import krived.web.info.model.entity.Check;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends GenericRepository<Check, Long> {
}

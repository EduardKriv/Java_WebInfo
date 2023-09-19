package krived.web.info.repository;

import krived.web.info.model.entity.CallBody;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRequestRepository extends GenericRepository<CallBody, Long> {
}

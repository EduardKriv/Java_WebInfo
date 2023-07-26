package krived.web.info.repository;

import krived.web.info.model.entity.TransferredPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferredPointRepository extends JpaRepository<TransferredPoint, Long> {
}

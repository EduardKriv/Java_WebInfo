package krived.web.info.repository;

import krived.web.info.model.entity.TimeTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTrackingRepository extends JpaRepository<TimeTracking, Long> {
}

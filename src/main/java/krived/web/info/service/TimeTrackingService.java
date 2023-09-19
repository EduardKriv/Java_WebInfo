package krived.web.info.service;

import krived.web.info.model.entity.TimeTracking;
import krived.web.info.repository.TimeTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTrackingService extends GenericService<TimeTracking, Long> {
    @Autowired
    public TimeTrackingService(TimeTrackingRepository timeTrackingRepository) {
        super(timeTrackingRepository);
    }
}

package krived.web.info.service;

import krived.web.info.model.entity.TimeTracking;
import krived.web.info.repository.TimeTrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeTrackingService {
    private final TimeTrackingRepository timeTrackingRepository;

    public List<TimeTracking> getAll() {
        return timeTrackingRepository.findAll();
    }

    public TimeTracking getById(Long id) {
        return timeTrackingRepository.getReferenceById(id);
    }

    public TimeTracking update(TimeTracking timeTracking) {
        return timeTrackingRepository.saveAndFlush(timeTracking);
    }

    public TimeTracking create(TimeTracking timeTracking) {
        return timeTrackingRepository.saveAndFlush(timeTracking);
    }

    public void delete(TimeTracking timeTracking) {
        timeTrackingRepository.delete(timeTracking);
    }
}

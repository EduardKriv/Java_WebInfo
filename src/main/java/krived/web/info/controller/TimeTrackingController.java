package krived.web.info.controller;

import krived.web.info.model.entity.TimeTracking;
import krived.web.info.repository.TimeTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/time_tracking")
public class TimeTrackingController {
    private final TimeTrackingRepository timeTrackingRepository;

    @Autowired
    public TimeTrackingController(TimeTrackingRepository timeTrackingRepository) {
        this.timeTrackingRepository = timeTrackingRepository;
    }

    @GetMapping("/all")
    public List<TimeTracking> allPeers() {
        return timeTrackingRepository.findAll();
    }

    @GetMapping("/{id}")
    public TimeTracking findById(@PathVariable Long id) {
        return timeTrackingRepository.findById(id).orElse(null);
    }
}

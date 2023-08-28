package krived.web.info.controller;

import krived.web.info.mapper.TimeTrackingMapper;
import krived.web.info.model.dto.TimeTrackingDto;
import krived.web.info.model.entity.TimeTracking;
import krived.web.info.service.TimeTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/time_tracking")
public class TimeTrackingController extends GenericController<TimeTracking, TimeTrackingDto, Long> {
    @Autowired
    public TimeTrackingController(TimeTrackingService timeTrackingService, TimeTrackingMapper timeTrackingMapper) {
        super(timeTrackingService, timeTrackingMapper);
    }

    @Override
    protected Class<TimeTrackingDto> getClazz() {
        return TimeTrackingDto.class;
    }
}

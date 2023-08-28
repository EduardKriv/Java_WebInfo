package krived.web.info.mapper;

import krived.web.info.model.dto.TimeTrackingDto;
import krived.web.info.model.entity.TimeTracking;
import org.mapstruct.*;

@Mapper(uses = PeerMapper.class)
public abstract class TimeTrackingMapper extends GenericMapper<TimeTracking, TimeTrackingDto> {
}


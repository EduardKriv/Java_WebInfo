package krived.web.info.mapper;

import krived.web.info.model.dto.TimeTrackingDto;
import krived.web.info.model.entity.TimeTracking;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = PeerMapper.class)
public abstract class TimeTrackingMapper {
    public abstract TimeTrackingDto toDto(TimeTracking timeTracking);
    public abstract TimeTracking toEntity(TimeTrackingDto timeTracking);
    public abstract List<TimeTrackingDto> toDtos(List<TimeTracking> timeTrackings);
    public abstract List<TimeTracking> toEntities(List<TimeTrackingDto> timeTrackingDtos);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateTimeTrackingFromDto(TimeTrackingDto dto, @MappingTarget TimeTracking timeTracking);

    TimeTrackingDto.State map(Integer value) {
        return value == 1 ? TimeTrackingDto.State.IN : TimeTrackingDto.State.OUT;
    }

    Integer map(TimeTrackingDto.@NotNull State value) {
        return value.ordinal() + 1;
    }
}


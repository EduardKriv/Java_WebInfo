package krived.web.info.mapper;

import krived.web.info.model.dto.VerterDto;
import krived.web.info.model.entity.Verter;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = CheckMapper.class )
public abstract class VerterMapper {
    public abstract VerterDto toDto(Verter verter);
    public abstract Verter toEntity(VerterDto verter);
    public abstract List<VerterDto> toDtos(List<Verter> verters);
    public abstract List<Verter> toEntities(List<VerterDto> verters);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateVerterFromDto(VerterDto dto, @MappingTarget Verter verter);
}

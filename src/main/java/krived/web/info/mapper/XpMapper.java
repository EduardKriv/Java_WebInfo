package krived.web.info.mapper;

import krived.web.info.model.dto.XpDto;
import krived.web.info.model.entity.Xp;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = CheckMapper.class )
public abstract class XpMapper {
    public abstract XpDto toDto(Xp xp);
    public abstract Xp toEntity(XpDto xp);
    public abstract List<XpDto> toDtos(List<Xp> xps);
    public abstract List<Xp> toEntities(List<XpDto> xps);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateXpFromDto(XpDto dto, @MappingTarget Xp xp);
}


package krived.web.info.mapper;

import krived.web.info.model.dto.BaseDto;
import krived.web.info.model.entity.BaseEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public abstract class GenericMapper<E extends BaseEntity, D extends BaseDto> {
    public abstract D toDto(E entity);
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract E toEntity(D dto);
    public abstract List<D> toDtos(List<E> entity);
    public abstract List<E> toEntities(List<D> dto);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntityFromDto(D dto, @MappingTarget E entity);
}

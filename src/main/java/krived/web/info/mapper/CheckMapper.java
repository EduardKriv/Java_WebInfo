package krived.web.info.mapper;

import krived.web.info.model.dto.CheckDto;
import krived.web.info.model.entity.Check;
import krived.web.info.service.CheckService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(uses = { PeerMapper.class, TaskMapper.class })
public abstract class CheckMapper {
    @Autowired
    private CheckService checkService;

    public abstract CheckDto toDto(Check check);
    public abstract Check toEntity(CheckDto checkDto);
    public abstract List<CheckDto> toDtos(List<Check> checks);
    public abstract List<Check> toEntities(List<CheckDto> checks);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateCheckFromDto(CheckDto dto, @MappingTarget Check check);

    public Long map(Check check) {
        return check.getId();
    }

    public Check map(Long check) {
        return checkService.getById(check);
    }
}
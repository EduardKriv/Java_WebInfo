package krived.web.info.mapper;

import krived.web.info.model.dto.TransferredPointDto;
import krived.web.info.model.entity.TransferredPoint;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = PeerMapper.class)
public abstract class TransferredPointMapper {
    public abstract TransferredPointDto toDto(TransferredPoint transferredPoint);
    public abstract TransferredPoint toEntity(TransferredPointDto transferredPoint);
    public abstract List<TransferredPointDto> toDtos(List<TransferredPoint> transferredPoints);
    public abstract List<TransferredPoint> toEntities(List<TransferredPointDto> transferredPointDtos);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateTransferredPointFromDto(TransferredPointDto dto, @MappingTarget TransferredPoint transferredPoint);

}


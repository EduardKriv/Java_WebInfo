package krived.web.info.mapper;

import krived.web.info.model.dto.TransferredPointsDto;
import krived.web.info.model.entity.TransferredPoint;
import org.mapstruct.*;

@Mapper(uses = PeerMapper.class)
public abstract class TransferredPointMapper extends GenericMapper<TransferredPoint, TransferredPointsDto>  {
}


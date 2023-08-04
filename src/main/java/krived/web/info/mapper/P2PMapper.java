package krived.web.info.mapper;

import krived.web.info.model.dto.P2PDto;
import krived.web.info.model.entity.P2P;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = { PeerMapper.class, CheckMapper.class })
public abstract class P2PMapper {
    public abstract P2PDto toDto(P2P p2p);
    public abstract P2P toEntity(P2PDto p2pDto);
    public abstract List<P2PDto> toDtos(List<P2P> p2pList);
    public abstract List<P2P> toEntities(List<P2PDto> p2pDtoList);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateP2PFromDto(P2PDto dto, @MappingTarget P2P p2p);
}

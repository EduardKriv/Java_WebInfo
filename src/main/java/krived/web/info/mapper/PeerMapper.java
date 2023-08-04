package krived.web.info.mapper;

import krived.web.info.model.dto.PeerDto;
import krived.web.info.model.entity.Peer;
import krived.web.info.service.PeerService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public abstract class PeerMapper {
    @Autowired
    private PeerService peerService;

    public abstract PeerDto toDto(Peer peer);
    public abstract Peer toEntity(PeerDto peerDto);
    public abstract List<PeerDto> toDtos(List<Peer> peers);
    public abstract List<Peer> toEntities(List<PeerDto> peers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updatePeerFromDto(PeerDto peerDto, @MappingTarget Peer peer);

    public Peer map(String nickname) {
        return peerService.getByNickname(nickname);
    }

    public String map(Peer peer) {
        return peer.getNickname();
    }
}

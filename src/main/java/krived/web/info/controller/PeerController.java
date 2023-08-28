package krived.web.info.controller;

import krived.web.info.mapper.PeerMapper;
import krived.web.info.model.dto.PeerDto;
import krived.web.info.model.entity.Peer;
import krived.web.info.service.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/peer")
public class PeerController extends GenericController<Peer, PeerDto, String> {
    @Autowired
    public PeerController(PeerService peerService, PeerMapper peerMapper) {
        super(peerService, peerMapper);
    }

    @Override
    protected Class<PeerDto> getClazz() {
        return PeerDto.class;
    }
}
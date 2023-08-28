package krived.web.info.service;

import krived.web.info.model.entity.Peer;
import krived.web.info.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeerService extends GenericService<Peer, String> {
    @Autowired
    public PeerService(PeerRepository peerRepository) {
        super(peerRepository);
    }
}

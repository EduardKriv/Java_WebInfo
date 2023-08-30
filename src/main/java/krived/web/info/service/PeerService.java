package krived.web.info.service;

import krived.web.info.model.entity.Peer;
import krived.web.info.repository.PeerRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PeerService extends GenericService<Peer, String> {
    @Autowired
    public PeerService(PeerRepository peerRepository) {
        super(peerRepository);
    }
}

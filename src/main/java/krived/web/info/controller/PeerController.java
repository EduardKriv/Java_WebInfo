package krived.web.info.controller;

import krived.web.info.model.entity.Peer;
import krived.web.info.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/peer")
public class PeerController {
    private final PeerRepository peerRepository;

    @Autowired
    public PeerController(PeerRepository peerRepository) {
        this.peerRepository = peerRepository;
    }

    @GetMapping("/all")
    public List<Peer> allPeers() {
        return peerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Peer findById(@PathVariable String id) {
        return peerRepository.findById(id).orElse(null);
    }
}

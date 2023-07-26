package krived.web.info.controller;

import krived.web.info.model.entity.P2P;
import krived.web.info.repository.P2PRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/p2p")
public class P2PController {
    private final P2PRepository p2pRepository;

    @Autowired
    public P2PController(P2PRepository p2pRepository) {
        this.p2pRepository = p2pRepository;
    }

    @GetMapping("/all")
    public List<P2P> allPeers() {
        return p2pRepository.findAll();
    }

    @GetMapping("/{id}")
    public P2P findById(@PathVariable Long id) {
        return p2pRepository.findById(id).orElse(null);
    }
}

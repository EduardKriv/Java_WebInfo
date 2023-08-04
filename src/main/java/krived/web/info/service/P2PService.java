package krived.web.info.service;

import krived.web.info.model.entity.P2P;
import krived.web.info.repository.P2PRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class P2PService {
    private final P2PRepository p2pRepository;

    public List<P2P> getAll() {
        return p2pRepository.findAll();
    }

    public P2P getById(Long id) {
        return p2pRepository.getReferenceById(id);
    }

    public P2P update(P2P p2p) {
        return p2pRepository.saveAndFlush(p2p);
    }

    public P2P create(P2P p2p) {
        return p2pRepository.saveAndFlush(p2p);
    }

    public void delete(P2P p2p) {
        p2pRepository.delete(p2p);
    }
}

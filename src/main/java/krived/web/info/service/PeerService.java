package krived.web.info.service;

import krived.web.info.model.entity.Peer;
import krived.web.info.repository.PeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeerService {
    private final PeerRepository peerRepository;

    public List<Peer> getAll() {
        return peerRepository.findAll();
    }

    public Peer getByNickname(String id) {
        return peerRepository.getReferenceById(id);
    }

    public Peer update(Peer peer) {
        return peerRepository.saveAndFlush(peer);
    }

    public Peer create(Peer peer) {
        return peerRepository.saveAndFlush(peer);
    }

    public void delete(Peer peer) {
        peerRepository.delete(peer);
    }

    public void saveAll(List<Peer> peers) {
        peerRepository.saveAllAndFlush(peers);
    }
}

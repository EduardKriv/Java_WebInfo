package krived.web.info.repository;

import krived.web.info.model.entity.Peer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeerRepository extends JpaRepository<Peer, String> {
}

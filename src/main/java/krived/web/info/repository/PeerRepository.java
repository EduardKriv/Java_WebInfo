package krived.web.info.repository;

import krived.web.info.model.entity.Peer;
import org.springframework.stereotype.Repository;

@Repository
public interface PeerRepository extends GenericRepository<Peer, String> {
}

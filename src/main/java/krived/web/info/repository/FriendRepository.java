package krived.web.info.repository;

import krived.web.info.model.entity.Friend;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends GenericRepository<Friend, Long> {
}

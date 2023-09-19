package krived.web.info.service;

import krived.web.info.model.entity.Friend;
import krived.web.info.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService extends GenericService<Friend, Long> {
    @Autowired
    public FriendService(FriendRepository friendRepository) {
        super(friendRepository);
    }
}

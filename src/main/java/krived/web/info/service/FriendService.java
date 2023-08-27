package krived.web.info.service;

import krived.web.info.model.entity.Friend;
import krived.web.info.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;

    public List<Friend> getAll() {
        return friendRepository.findAll();
    }

    public Friend getById(Long id) {
        return friendRepository.getReferenceById(id);
    }

    public Friend update(Friend friend) {
        return friendRepository.saveAndFlush(friend);
    }

    public Friend create(Friend friend) {
        return friendRepository.saveAndFlush(friend);
    }

    public void delete(Friend friend) {
        friendRepository.delete(friend);
    }

    public void saveAll(List<Friend> friends) {
        friendRepository.saveAllAndFlush(friends);
    }
}

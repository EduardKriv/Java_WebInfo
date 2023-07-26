package krived.web.info.controller;

import krived.web.info.model.entity.Friend;
import krived.web.info.model.entity.Peer;
import krived.web.info.repository.FriendRepository;
import krived.web.info.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {
    private final FriendRepository friendRepository;

    @Autowired
    public FriendController(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @GetMapping("/all")
    public List<Friend> allPeers() {
        return friendRepository.findAll();
    }

    @GetMapping("/{id}")
    public Friend findById(@PathVariable Long id) {
        return friendRepository.findById(id).orElse(null);
    }
}

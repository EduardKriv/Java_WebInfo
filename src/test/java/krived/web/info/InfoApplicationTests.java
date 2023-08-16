package krived.web.info;

import krived.web.info.model.entity.Peer;
import krived.web.info.repository.PeerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


//@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class InfoApplicationTests {

//    @Autowired
//    private PeerRepository peerRepository;
//
//    @Test
//    public void whenCalledSave_thenCorrectNumberOfPeers() {
//        List<Peer> peers = peerRepository.findAll();
//    }
}
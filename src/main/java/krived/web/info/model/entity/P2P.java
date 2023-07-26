package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "p2p")
public class P2P {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "check", referencedColumnName = "id")
    private Check check;

    @OneToOne
    @JoinColumn(name = "checkingPeer", referencedColumnName = "nickname")
    private Peer checkingPeer;

    @Column(name = "state")
    private String state;

    @Column(name = "time")
    private LocalDateTime time;
}

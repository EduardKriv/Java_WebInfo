package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "p2p")
@EqualsAndHashCode(callSuper = false)
public class P2P extends BaseEntity<Long> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "check_id", referencedColumnName = "id")
    private Check check;

    @OneToOne
    @JoinColumn(name = "checking_peer", referencedColumnName = "nickname")
    private Peer checkingPeer;

    @Column(name = "state")
    private String state;

    @Column(name = "time")
    private LocalTime time;
}
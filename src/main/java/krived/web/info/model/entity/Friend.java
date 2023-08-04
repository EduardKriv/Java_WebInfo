package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "friends")
public class Friend {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer1", referencedColumnName = "nickname")
    private Peer peer1;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer2", referencedColumnName = "nickname")
    private Peer peer2;
}

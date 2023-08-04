package krived.web.info.model.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "recommendations")
public class Recommendation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer", referencedColumnName = "nickname")
    private Peer peer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recommended_peer", referencedColumnName = "nickname")
    private Peer recommendedPeer;
}

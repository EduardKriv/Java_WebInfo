package krived.web.info.model.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "recommendations")
public class Recommendation {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer", referencedColumnName = "nickname")
    private Peer peer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recommendedPeer", referencedColumnName = "nickname")
    private Peer recommendedPeer;
}

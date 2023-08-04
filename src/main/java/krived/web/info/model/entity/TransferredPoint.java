package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "transferred_points")
public class TransferredPoint {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "checking_peer", referencedColumnName = "nickname")
    private Peer checkingPeer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "checked_peer", referencedColumnName = "nickname")
    private Peer checkedPeer;

    @Column(name = "points_amount")
    private Integer pointsAmount;
}

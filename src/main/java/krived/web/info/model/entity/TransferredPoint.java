package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "transferred_points")
@EqualsAndHashCode(callSuper = false)
public class TransferredPoint extends BaseEntity<Long> {
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

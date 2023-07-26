package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "transferredPoints")
public class TransferredPoint {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "checkingPeer", referencedColumnName = "nickname")
    private Peer checkingPeer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "checkedPeer", referencedColumnName = "nickname")
    private Peer checkedPeer;

    @Column(name = "pointsAmount")
    private int pointsAmount;
}

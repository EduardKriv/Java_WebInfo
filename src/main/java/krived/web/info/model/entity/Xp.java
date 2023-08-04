package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "xp")
public class Xp {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "check_id", referencedColumnName = "id")
    private Check check;

    @Column(name = "xp_amount")
    private Integer xpAmount;
}
package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "xp")
@EqualsAndHashCode(callSuper = false)
public class Xp extends BaseEntity<Long> {
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
package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "xp")
public class Xp {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "check", referencedColumnName = "id")
    private Check check;

    @Column(name = "xpAmount")
    private int xpAmount;
}
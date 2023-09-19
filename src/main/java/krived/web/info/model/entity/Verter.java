package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "verter")
@EqualsAndHashCode(callSuper = false)
public class Verter extends BaseEntity<Long> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "check_id", referencedColumnName = "id")
    private Check check;

    @Column(name = "state")
    private String state;

    @Column(name = "time")
    private LocalTime time;
}

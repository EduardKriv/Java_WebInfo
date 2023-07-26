package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "verter")
public class Verter {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "check", referencedColumnName = "id")
    private Check check;

    @Column(name = "state")
    private String state;

    @Column(name = "time")
    private LocalDateTime time;
}

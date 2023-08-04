package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "checks")
public class Check implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer", referencedColumnName = "nickname")
    private Peer peer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task", referencedColumnName = "title")
    private Task task;

    @Column(name = "date", nullable = false)
    private LocalDate date;
}

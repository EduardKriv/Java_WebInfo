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

    @Column(name = "peer", nullable = false)
    private String name;

    @Column(name = "task", nullable = false)
    private String task;

    @Column(name = "date", nullable = false)
    private LocalDate date;
}

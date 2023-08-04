package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "title")
    private String title;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_task", referencedColumnName = "title")
    private Task parentTask;

    @Column(name = "max_xp")
    private Integer maxXp;
}

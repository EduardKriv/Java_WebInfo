package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "tasks")
@EqualsAndHashCode(callSuper = true)
public class Task extends BaseEntity {
    @Id
    @Column(name = "title")
    private String title;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_task", referencedColumnName = "title")
    private Task parentTask;

    @Column(name = "max_xp")
    private Integer maxXp;
}
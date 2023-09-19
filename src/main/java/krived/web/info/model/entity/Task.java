package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "tasks")
@EqualsAndHashCode(callSuper = false)
public class Task extends BaseEntity<String> {
    @Id
    @Column(name = "title")
    private String title;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_task", referencedColumnName = "title")
    private Task parentTask;

    @Column(name = "max_xp")
    private Integer maxXp;

    @Override
    public String getId() {
        return title;
    }
}
package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "procedures")
@EqualsAndHashCode(callSuper = false)
public class CallBody extends BaseEntity<Long> {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "call")
    private String call;
}

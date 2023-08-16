package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "procedures")
public class CallBody {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "call")
    private String call;
}

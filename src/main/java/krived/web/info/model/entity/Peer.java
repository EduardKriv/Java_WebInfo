package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "peers")
@EqualsAndHashCode(callSuper = false)
public class Peer extends BaseEntity<String> {
    @Id
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;


    @Override
    public String getId() {
        return nickname;
    }
}

package krived.web.info.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "peers")
public class Peer {
    @Id
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;
}

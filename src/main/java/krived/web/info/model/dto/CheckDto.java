package krived.web.info.model.dto;

import krived.web.info.model.entity.Peer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CheckDto {
    private Long id;
    private String peer;
    private String task;
    private LocalDate date;
}

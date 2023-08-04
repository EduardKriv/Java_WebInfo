package krived.web.info.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class P2PDto {
    private Long id;
    private Long check;
    private String checkingPeer;
    private String state;
    private LocalTime time;
}

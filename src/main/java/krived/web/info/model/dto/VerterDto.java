package krived.web.info.model.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class VerterDto {
    private Long id;
    private Long check;
    private String state;
    private LocalTime time;
}

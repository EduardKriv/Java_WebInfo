package krived.web.info.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TimeTrackingDto {
    public enum State { IN, OUT }
    private Long id;
    private String peer;
    private LocalDate date;
    private LocalTime time;
    private State state;
}

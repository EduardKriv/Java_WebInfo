package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeTrackingDto extends BaseDto {
    @CsvBindByName(column = "id", required = true)
    private Long id;

    @CsvBindByName(column = "peer", required = true)
    @CsvBindByPosition(position = 0)
    private String peer;

    @CsvBindByName(column = "date", required = true)
    @CsvBindByPosition(position = 1)
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate date;

    @CsvBindByName(column = "time", required = true)
    @CsvBindByPosition(position = 2)
    @CsvDate(value = "HH:mm")
    private LocalTime time;

    @CsvBindByName(column = "state", required = true)
    @CsvBindByPosition(position = 3)
    private Integer state;
}

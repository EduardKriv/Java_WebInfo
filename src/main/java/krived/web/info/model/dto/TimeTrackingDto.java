package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import krived.web.info.model.CsvBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeTrackingDto extends CsvBean {
    private Long id;
    @CsvBindByName(required = true)
    private String peer;
    @CsvBindByName(required = true)
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate date;
    @CsvBindByName(required = true)
    @CsvDate(value = "HH:mm")
    private LocalTime time;
    @CsvBindByName(required = true)
    private Integer state;
}

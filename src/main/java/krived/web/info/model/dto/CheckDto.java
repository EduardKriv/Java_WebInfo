package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class CheckDto extends BaseDto {
    @CsvBindByName(column = "id", required = true)
    private Long id;

    @CsvBindByName(column = "peer", required = true)
    @CsvBindByPosition(position = 0)
    private String peer;

    @CsvBindByName(column = "task", required = true)
    @CsvBindByPosition(position = 1)
    private String task;

    @CsvBindByName(column = "date", required = true)
    @CsvBindByPosition(position = 2)
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate date;
}

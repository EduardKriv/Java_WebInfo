package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import krived.web.info.model.CsvBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class CheckDto extends CsvBean {
    private Long id;
    @CsvBindByName(required = true)
    private String peer;
    @CsvBindByName(required = true)
    private String task;
    @CsvBindByName(required = true)
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate date;
}

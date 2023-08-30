package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class XpDto extends BaseDto {
    @CsvBindByName(column = "id", required = true)
    private Long id;

    @CsvBindByName(column = "check_id", required = true)
    @CsvBindByPosition(position = 0)
    private Long check;

    @CsvBindByName(column = "xp_amount", required = true)
    @CsvBindByPosition(position = 1)
    private Integer xpAmount;
}

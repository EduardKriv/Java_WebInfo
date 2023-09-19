package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TaskDto extends BaseDto {
    @CsvBindByName(column = "title", required = true)
    @CsvBindByPosition(position = 0)
    private String title;

    @CsvBindByName(column = "parent_task", required = true)
    @CsvBindByPosition(position = 1)
    private String parentTask;

    @CsvBindByName(column = "max_xp", required = true)
    @CsvBindByPosition(position = 2)
    private Integer maxXp;
}
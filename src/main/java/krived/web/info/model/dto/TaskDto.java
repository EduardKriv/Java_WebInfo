package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import krived.web.info.model.CsvBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TaskDto extends CsvBean {
    @CsvBindByName(required = true)
    private String title;
    @CsvBindByName(column = "parent_task", required = true)
    private String parentTask;
    @CsvBindByName(column = "max_xp", required = true)
    private Integer maxXp;
}
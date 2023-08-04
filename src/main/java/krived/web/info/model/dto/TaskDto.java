package krived.web.info.model.dto;

import lombok.Data;

@Data
public class TaskDto {
    private String title;
    private String parentTask;
    private Integer maxXp;
}

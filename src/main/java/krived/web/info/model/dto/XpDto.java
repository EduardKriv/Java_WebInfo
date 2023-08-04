package krived.web.info.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class XpDto {
    private Long id;
    private Long check;
    private Integer xpAmount;
}

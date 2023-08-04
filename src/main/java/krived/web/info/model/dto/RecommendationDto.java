package krived.web.info.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RecommendationDto {
    private Long id;
    private String peer;
    private String recommendedPeer;
}

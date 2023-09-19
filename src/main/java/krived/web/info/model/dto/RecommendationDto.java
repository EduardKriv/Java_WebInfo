package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RecommendationDto extends BaseDto {
    @CsvBindByName(column = "id", required = true)
    private Long id;

    @CsvBindByName(column = "peer", required = true)
    @CsvBindByPosition(position = 0)
    private String peer;

    @CsvBindByName(column = "recommended_peer", required = true)
    @CsvBindByPosition(position = 1)
    private String recommendedPeer;
}

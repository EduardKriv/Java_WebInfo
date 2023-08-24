package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import krived.web.info.model.CsvBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RecommendationDto extends CsvBean {
    private Long id;
    @CsvBindByName(required = true)
    private String peer;
    @CsvBindByName(column = "recommended_peer", required = true)
    private String recommendedPeer;
}

package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class TransferredPointDto {
    private Long id;
    @CsvBindByName(required = true)
    private String checkingPeer;
    @CsvBindByName(required = true)
    private String checkedPeer;
    @CsvBindByName(required = true)
    private Integer pointsAmount;
}

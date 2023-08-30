package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransferredPointsDto extends BaseDto {
    @CsvBindByName(column = "id", required = true)
    private Long id;

    @CsvBindByName(column = "checking_peer", required = true)
    @CsvBindByPosition(position = 0)
    private String checkingPeer;

    @CsvBindByName(column = "checked_peer", required = true)
    @CsvBindByPosition(position = 1)
    private String checkedPeer;

    @CsvBindByName(column = "points_amount", required = true)
    @CsvBindByPosition(position = 2)
    private Integer pointsAmount;
}

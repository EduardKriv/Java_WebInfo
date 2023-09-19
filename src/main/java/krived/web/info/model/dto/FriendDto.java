package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FriendDto extends BaseDto {
    @CsvBindByName(column = "id", required = true)
    private Long id;

    @CsvBindByName(column = "peer1", required = true)
    @CsvBindByPosition(position = 0)
    private String peer1;

    @CsvBindByPosition(position = 1)
    @CsvBindByName(column = "peer2", required = true)
    private String peer2;
}

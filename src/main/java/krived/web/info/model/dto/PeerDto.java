package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PeerDto extends BaseDto {
    @CsvBindByName(column = "nickname", required = true)
    @CsvBindByPosition(position = 0)
    private String nickname;

    @CsvBindByName(column = "birthday", required = true)
    @CsvBindByPosition(position = 1)
    private String birthday;
}

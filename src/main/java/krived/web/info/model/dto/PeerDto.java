package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class PeerDto {
    @CsvBindByName
    private String nickname;
    @CsvBindByName
    private String birthday;
}

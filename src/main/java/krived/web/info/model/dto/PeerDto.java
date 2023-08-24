package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import krived.web.info.model.CsvBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PeerDto extends CsvBean {
    @CsvBindByName(required = true)
    private String nickname;
    @CsvBindByName(required = true)
    private String birthday;
}

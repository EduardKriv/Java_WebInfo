package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class P2PDto extends BaseDto {
    @CsvBindByName(column = "id", required = true)
    private Long id;

    @CsvBindByName(column = "check_id", required = true)
    @CsvBindByPosition(position = 0)
    private Long check;

    @CsvBindByName(column = "checking_peer", required = true)
    @CsvBindByPosition(position = 1)
    private String checkingPeer;

    @CsvBindByName(column = "state", required = true)
    @CsvBindByPosition(position = 2)
    private String state;

    @CsvBindByName(column = "time", required = true)
    @CsvBindByPosition(position = 3)
    @CsvDate(value = "HH:mm:ss")
    private LocalTime time;
}

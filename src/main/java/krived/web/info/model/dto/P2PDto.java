package krived.web.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import krived.web.info.model.CsvBean;
import lombok.Data;

import java.time.LocalTime;

@Data
public class P2PDto extends CsvBean {
    private Long id;
    @CsvBindByName(column = "check_id", required = true)
    private Long check;
    @CsvBindByName(column = "checking_peer", required = true)
    private String checkingPeer;
    @CsvBindByName(required = true)
    private String state;
    @CsvBindByName(required = true)
    @CsvDate(value = "HH:mm:ss")
    private LocalTime time;
}

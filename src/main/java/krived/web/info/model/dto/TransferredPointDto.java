package krived.web.info.model.dto;

import lombok.Data;

@Data
public class TransferredPointDto {
    private Long id;
    private String checkingPeer;
    private String checkedPeer;
    private Integer pointsAmount;
}

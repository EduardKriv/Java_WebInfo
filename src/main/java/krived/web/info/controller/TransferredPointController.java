package krived.web.info.controller;

import krived.web.info.mapper.TransferredPointMapper;
import krived.web.info.model.dto.TransferredPointsDto;
import krived.web.info.model.entity.TransferredPoint;
import krived.web.info.service.TransferredPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transferred_point")
public class TransferredPointController extends GenericController<TransferredPoint, TransferredPointsDto, Long> {
    @Autowired
    public TransferredPointController(TransferredPointService transferredPointService, TransferredPointMapper transferredPointMapper) {
        super(transferredPointService, transferredPointMapper);
    }

    @Override
    protected Class<TransferredPointsDto> getClazz() {
        return TransferredPointsDto.class;
    }
}

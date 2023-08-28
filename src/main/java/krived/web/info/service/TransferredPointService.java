package krived.web.info.service;

import krived.web.info.model.entity.TransferredPoint;
import krived.web.info.repository.TransferredPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferredPointService extends GenericService<TransferredPoint, Long> {
    @Autowired
    public TransferredPointService(TransferredPointRepository transferredPointRepository) {
        super(transferredPointRepository);
    }
}

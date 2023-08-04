package krived.web.info.service;

import krived.web.info.model.entity.TransferredPoint;
import krived.web.info.repository.TransferredPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferredPointService {
    private final TransferredPointRepository transferredPointRepository;

    public List<TransferredPoint> getAll() {
        return transferredPointRepository.findAll();
    }

    public TransferredPoint getById(Long id) {
        return transferredPointRepository.getReferenceById(id);
    }

    public TransferredPoint update(TransferredPoint transferredPoint) {
        return transferredPointRepository.saveAndFlush(transferredPoint);
    }

    public TransferredPoint create(TransferredPoint transferredPoint) {
        return transferredPointRepository.saveAndFlush(transferredPoint);
    }

    public void delete(TransferredPoint transferredPoint) {
        transferredPointRepository.delete(transferredPoint);
    }
}

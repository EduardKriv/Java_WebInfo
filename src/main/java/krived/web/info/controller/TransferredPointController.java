package krived.web.info.controller;

import krived.web.info.model.entity.TransferredPoint;
import krived.web.info.repository.TransferredPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transferred_point")
public class TransferredPointController {
    private final TransferredPointRepository transferredPointRepository;

    @Autowired
    public TransferredPointController(TransferredPointRepository transferredPointRepository) {
        this.transferredPointRepository = transferredPointRepository;
    }

    @GetMapping("/all")
    public List<TransferredPoint> allPeers() {
        return transferredPointRepository.findAll();
    }

    @GetMapping("/{id}")
    public TransferredPoint findById(@PathVariable Long id) {
        return transferredPointRepository.findById(id).orElse(null);
    }
}

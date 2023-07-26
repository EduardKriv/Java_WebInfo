package krived.web.info.controller;

import krived.web.info.model.entity.Xp;
import krived.web.info.repository.XpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/xp")
public class XpController {
    private final XpRepository xpRepository;

    @Autowired
    public XpController(XpRepository xpRepository) {
        this.xpRepository = xpRepository;
    }

    @GetMapping("/all")
    public List<Xp> allPeers() {
        return xpRepository.findAll();
    }

    @GetMapping("/{id}")
    public Xp findById(@PathVariable Long id) {
        return xpRepository.findById(id).orElse(null);
    }
}

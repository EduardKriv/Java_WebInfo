package krived.web.info.controller;

import krived.web.info.model.entity.Verter;
import krived.web.info.repository.VerterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/verter")
public class VerterController {
    private final VerterRepository verterRepository;

    @Autowired
    public VerterController(VerterRepository verterRepository) {
        this.verterRepository = verterRepository;
    }

    @GetMapping("/all")
    public List<Verter> allPeers() {
        return verterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Verter findById(@PathVariable Long id) {
        return verterRepository.findById(id).orElse(null);
    }
}

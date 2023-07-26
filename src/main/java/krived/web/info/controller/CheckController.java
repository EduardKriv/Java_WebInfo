package krived.web.info.controller;

import krived.web.info.model.entity.Check;
import krived.web.info.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckController {
    private final CheckRepository checkRepository;

    @Autowired
    public CheckController(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    @GetMapping("/all")
    public List<Check> allPeers() {
        return checkRepository.findAll();
    }

    @GetMapping("/{id}")
    public Check findById(@PathVariable Long id) {
        return checkRepository.findById(id).orElse(null);
    }
}

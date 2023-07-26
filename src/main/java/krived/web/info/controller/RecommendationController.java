package krived.web.info.controller;

import krived.web.info.model.entity.Recommendation;
import krived.web.info.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendtion")
public class RecommendationController {
    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationController(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @GetMapping("/all")
    public List<Recommendation> allPeers() {
        return recommendationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Recommendation findById(@PathVariable Long id) {
        return recommendationRepository.findById(id).orElse(null);
    }
}

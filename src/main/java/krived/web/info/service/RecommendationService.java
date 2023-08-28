package krived.web.info.service;

import krived.web.info.model.entity.Recommendation;
import krived.web.info.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService extends GenericService<Recommendation, Long> {
    @Autowired
    public RecommendationService(RecommendationRepository recommendationRepository) {
        super(recommendationRepository);
    }
}

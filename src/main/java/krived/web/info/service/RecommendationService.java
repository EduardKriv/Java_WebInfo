package krived.web.info.service;

import krived.web.info.model.entity.Recommendation;
import krived.web.info.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;

    public List<Recommendation> getAll() {
        return recommendationRepository.findAll();
    }

    public Recommendation getById(Long id) {
        return recommendationRepository.getReferenceById(id);
    }

    public Recommendation update(Recommendation recommendation) {
        return recommendationRepository.saveAndFlush(recommendation);
    }

    public Recommendation create(Recommendation recommendation) {
        return recommendationRepository.saveAndFlush(recommendation);
    }

    public void delete(Recommendation recommendation) {
        recommendationRepository.delete(recommendation);
    }

    public void saveAll(List<Recommendation> recommendation) {
        recommendationRepository.saveAllAndFlush(recommendation);
    }
}

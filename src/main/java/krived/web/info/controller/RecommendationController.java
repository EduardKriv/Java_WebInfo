package krived.web.info.controller;

import krived.web.info.mapper.RecommendationMapper;
import krived.web.info.model.dto.RecommendationDto;
import krived.web.info.model.entity.Recommendation;
import krived.web.info.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recommendation")
public class RecommendationController {
    private final RecommendationService recommendationService;
    private final RecommendationMapper recommendationMapper;

    @GetMapping("/all")
    public String allRecommendations(Model model) {
        List<Recommendation> recommendations = recommendationService.getAll();
        List<RecommendationDto> recommendationsDtos = recommendationMapper.toDtos(recommendations);
        model.addAttribute("tableName", "recommendations");
        model.addAttribute("allRecommendations", recommendationsDtos);
        return "home";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addedRecommendation") @NotNull RecommendationDto dto) {
        Recommendation recommendationEntity = recommendationMapper.toEntity(dto);
        recommendationService.create(recommendationEntity);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("updatedRecommendation") @NotNull RecommendationDto dto) {
        System.out.println(dto);
        Recommendation recommendationEntity = recommendationService.getById(dto.getId());
        recommendationMapper.updateRecommendationFromDto(dto, recommendationEntity);
        recommendationService.update(recommendationEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String remove(@ModelAttribute("deletedRecommendation") @NotNull RecommendationDto dto) {
        Recommendation recommendationEntity = recommendationService.getById(dto.getId());
        recommendationService.delete(recommendationEntity);
        return "redirect:all";
    }
}

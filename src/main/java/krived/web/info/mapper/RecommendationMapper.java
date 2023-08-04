package krived.web.info.mapper;

import krived.web.info.model.dto.RecommendationDto;
import krived.web.info.model.entity.Recommendation;
import org.mapstruct.*;

import java.util.List;
@Mapper(uses = PeerMapper.class)
public abstract class RecommendationMapper {
    public abstract RecommendationDto toDto(Recommendation recommendation);
    public abstract Recommendation toEntity(RecommendationDto RecommendationDto);
    public abstract List<RecommendationDto> toDtos(List<Recommendation> recommendations);
    public abstract List<Recommendation> toEntities(List<RecommendationDto> recommendations);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateRecommendationFromDto(RecommendationDto dto, @MappingTarget Recommendation recommendation);
}

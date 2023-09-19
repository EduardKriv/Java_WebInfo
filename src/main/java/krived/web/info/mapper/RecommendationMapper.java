package krived.web.info.mapper;

import krived.web.info.model.dto.RecommendationDto;
import krived.web.info.model.entity.Recommendation;
import org.mapstruct.*;

@Mapper(uses = PeerMapper.class)
public abstract class RecommendationMapper extends GenericMapper<Recommendation, RecommendationDto> {
}

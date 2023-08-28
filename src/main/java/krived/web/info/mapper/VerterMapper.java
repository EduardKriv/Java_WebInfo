package krived.web.info.mapper;

import krived.web.info.model.dto.VerterDto;
import krived.web.info.model.entity.Verter;
import org.mapstruct.*;

@Mapper(uses = CheckMapper.class )
public abstract class VerterMapper extends GenericMapper<Verter, VerterDto> {
}

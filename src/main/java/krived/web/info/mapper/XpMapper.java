package krived.web.info.mapper;

import krived.web.info.model.dto.XpDto;
import krived.web.info.model.entity.Xp;
import org.mapstruct.*;

@Mapper(uses = CheckMapper.class )
public abstract class XpMapper extends GenericMapper<Xp, XpDto> {
}


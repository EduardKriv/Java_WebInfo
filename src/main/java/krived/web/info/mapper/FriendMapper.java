package krived.web.info.mapper;

import krived.web.info.model.dto.FriendDto;
import krived.web.info.model.entity.Friend;
import org.mapstruct.*;

@Mapper(uses = PeerMapper.class)
public abstract class FriendMapper extends GenericMapper <Friend, FriendDto> {
}

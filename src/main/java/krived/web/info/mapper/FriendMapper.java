package krived.web.info.mapper;

import krived.web.info.model.dto.FriendDto;
import krived.web.info.model.entity.Friend;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = PeerMapper.class)
public abstract class FriendMapper {
    public abstract FriendDto toDto(Friend friend);
    public abstract List<FriendDto> toDtos(List<Friend> friend);
    public abstract List<Friend> toEntities(List<FriendDto> friend);
    public abstract Friend toEntity(FriendDto dto);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateFriendFromDto(FriendDto dto, @MappingTarget Friend friend);
}

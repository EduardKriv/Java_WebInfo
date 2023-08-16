package krived.web.info.controller;

import krived.web.info.mapper.FriendMapper;
import krived.web.info.model.dto.FriendDto;
import krived.web.info.model.entity.Friend;
import krived.web.info.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {
    private final FriendService friendService;
    private final FriendMapper friendMapper;

    @GetMapping("/all")
    public String allFriends(Model model) {
        List<Friend> friends = friendService.getAll();
        List<FriendDto> friendDtos = friendMapper.toDtos(friends);
        model.addAttribute("tableName", "friends");
        model.addAttribute("allFriends", friendDtos);
        return "index";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute(value="addedFriend") FriendDto dto) {
        System.out.println(dto);
        dto.setPeer1("fedosiy");
        dto.setPeer2("fedosiy");

        Friend friendEntity = friendMapper.toEntity(dto);
        friendService.create(friendEntity);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(value="updatedFriend") FriendDto dto) {
        dto.setPeer2("duck");

        Friend friendEntity = friendService.getById(dto.getId());
        friendMapper.updateFriendFromDto(dto, friendEntity);
        friendService.update(friendEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute(value="updatedFriend") FriendDto dto) {
        Friend friend = friendService.getById(dto.getId());
        friendService.delete(friend);
        return "redirect:all";
    }
}

package krived.web.info.controller;

import jakarta.servlet.http.HttpServletResponse;
import krived.web.info.mapper.FriendMapper;
import krived.web.info.model.dto.FriendDto;
import krived.web.info.model.entity.Friend;
import krived.web.info.utility.CsvConverter;
import krived.web.info.service.FriendService;
import krived.web.info.utility.DtoMetaData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {
    private final FriendService friendService;
    private final FriendMapper friendMapper;

    @GetMapping("/all")
    public String allFriends(Model model) {
        List<FriendDto> friendDtos = friendMapper.toDtos(friendService.getAll());

        model.addAttribute("columnNames", DtoMetaData.getColumnNames(FriendDto.class));
        model.addAttribute("tableName", "friends");
        model.addAttribute("allFriends", friendDtos);
        return "index";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addedFriend") FriendDto dto) {
        System.out.println(dto);
        dto.setPeer1("fedosiy");
        dto.setPeer2("fedosiy");

        Friend friendEntity = friendMapper.toEntity(dto);
        friendService.create(friendEntity);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("updatedFriend") FriendDto dto) {
        dto.setPeer2("duck");

        Friend friendEntity = friendService.getById(dto.getId());
        friendMapper.updateFriendFromDto(dto, friendEntity);
        friendService.update(friendEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("updatedFriend") FriendDto dto) {
        Friend friend = friendService.getById(dto.getId());
        friendService.delete(friend);
        return "redirect:all";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        List<FriendDto> friends = CsvConverter.upload(file, FriendDto.class);
        friendService.saveAll(friendMapper.toEntities(friends));
        return "redirect:all";
    }

    @GetMapping("/unload")
    public void unload(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"friends.csv\"");
        List<FriendDto> beans = friendMapper.toDtos(friendService.getAll());
        CsvConverter.unload(servletResponse.getWriter(), beans, FriendDto.class);
    }
}

package krived.web.info.controller;

import krived.web.info.mapper.P2PMapper;
import krived.web.info.model.dto.P2PDto;
import krived.web.info.model.entity.P2P;
import krived.web.info.service.P2PService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/p2p")
public class P2PController {
    private final P2PService p2pService;
    private final P2PMapper p2pMapper;

    @GetMapping("/all")
    public String allP2Ps(Model model) {
        List<P2P> p2p = p2pService.getAll();
        List<P2PDto> p2pDtos = p2pMapper.toDtos(p2p);
        model.addAttribute("tableName", "p2p");
        model.addAttribute("allP2P", p2pDtos);
        return "home";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute(value="addedP2P") P2PDto dto) {
        System.out.println(dto);
//        dto.setPeer1("fedosiy");
//        dto.setPeer2("fedosiy");

        P2P p2pEntity = p2pMapper.toEntity(dto);
        p2pService.create(p2pEntity);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(value="updatedP2P") P2PDto dto) {
//        dto.setPeer2("duck");

        P2P p2pEntity = p2pService.getById(dto.getId());
        p2pMapper.updateP2PFromDto(dto, p2pEntity);
        p2pService.update(p2pEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute(value="updatedP2P") P2PDto dto) {
        P2P p2p = p2pService.getById(dto.getId());
        p2pService.delete(p2p);
        return "redirect:all";
    }
}

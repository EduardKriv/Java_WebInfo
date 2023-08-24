package krived.web.info.controller;

import krived.web.info.mapper.PeerMapper;
import krived.web.info.model.CsvBean;
import krived.web.info.model.dto.P2PDto;
import krived.web.info.model.dto.PeerDto;
import krived.web.info.model.entity.P2P;
import krived.web.info.model.entity.Peer;
import krived.web.info.service.ConvertCsvService;
import krived.web.info.service.PeerService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/peer")
public class PeerController {
    private final PeerService peerService;
    private final PeerMapper peerMapper;

    @GetMapping("/all")
    public String allPeers(Model model) {
        List<Peer> peers = peerService.getAll();
        List<PeerDto> peersDtos = peerMapper.toDtos(peers);
        model.addAttribute("tableName", "peers");
        model.addAttribute("allPeers", peersDtos);
        return "index";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addedPeer") @NotNull PeerDto dto) {
        dto.setNickname("fedosiy");
        dto.setBirthday("2015-12-12");

        Peer peerEntity = peerMapper.toEntity(dto);
        peerService.create(peerEntity);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("updatedPeer") @NotNull PeerDto dto) {
        System.out.println(dto);
        Peer peerEntity = peerService.getByNickname(dto.getNickname());
        peerMapper.updatePeerFromDto(dto, peerEntity);
        peerService.update(peerEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String remove(@ModelAttribute("deletedPeer") @NotNull PeerDto dto) {
        Peer peerEntity = peerService.getByNickname(dto.getNickname());
        peerService.delete(peerEntity);
        return "redirect:all";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        @SuppressWarnings("unchecked")
        List<PeerDto> peers = (List<PeerDto>)ConvertCsvService.upload(file, PeerDto.class);
        peerService.saveAll(peerMapper.toEntities(peers));
        return "redirect:all";
    }
}

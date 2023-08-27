package krived.web.info.controller;

import jakarta.servlet.http.HttpServletResponse;
import krived.web.info.mapper.PeerMapper;
import krived.web.info.model.dto.PeerDto;
import krived.web.info.model.entity.Peer;
import krived.web.info.utility.CsvConverter;
import krived.web.info.service.PeerService;
import krived.web.info.utility.DtoMetaData;
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
    public String allPeers(@NotNull Model model) {
        List<PeerDto> peersDtos = peerMapper.toDtos(peerService.getAll());

        model.addAttribute("columnNames", DtoMetaData.getColumnNames(PeerDto.class));
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
        List<PeerDto> peers = CsvConverter.upload(file, PeerDto.class);
        peerService.saveAll(peerMapper.toEntities(peers));
        return "redirect:all";
    }

    @GetMapping("/unload")
    public void unload(@NotNull HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"peers.csv\"");
        List<PeerDto> beans = peerMapper.toDtos(peerService.getAll());
        CsvConverter.unload(servletResponse.getWriter(), beans, PeerDto.class);
    }
}
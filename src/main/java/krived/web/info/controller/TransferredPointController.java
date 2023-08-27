package krived.web.info.controller;

import jakarta.servlet.http.HttpServletResponse;
import krived.web.info.mapper.TransferredPointMapper;
import krived.web.info.model.dto.TransferredPointDto;
import krived.web.info.model.entity.TransferredPoint;
import krived.web.info.utility.CsvConverter;
import krived.web.info.service.TransferredPointService;
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
@RequestMapping("/transferred_point")
public class TransferredPointController {
    private final TransferredPointService transferredPointService;
    private final TransferredPointMapper transferredPointMapper;

    @GetMapping("/all")
    public String allTransferredPoints(Model model) {
        List<TransferredPointDto> transferredPointsDtos =
                transferredPointMapper.toDtos(transferredPointService.getAll());

        model.addAttribute("columnNames", DtoMetaData.getColumnNames(TransferredPointDto.class));
        model.addAttribute("tableName", "transferred_points");
        model.addAttribute("allTransferredPoints", transferredPointsDtos);
        return "index";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addedTransferredPoint") @NotNull TransferredPointDto dto) {
//        TransferredPoint transferredPointEntity = transferredPointMapper.toEntity(dto);
//        transferredPointService.create(transferredPointEntity);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("updatedTransferredPoint") @NotNull TransferredPointDto dto) {
        TransferredPoint transferredPointEntity = transferredPointService.getById(dto.getId());
        transferredPointMapper.updateTransferredPointFromDto(dto, transferredPointEntity);
        transferredPointService.update(transferredPointEntity);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String remove(@ModelAttribute("deletedTransferredPoint") @NotNull TransferredPointDto dto) {
        TransferredPoint transferredPointEntity = transferredPointService.getById(dto.getId());
        transferredPointService.delete(transferredPointEntity);
        return "redirect:all";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        List<TransferredPointDto> peers = CsvConverter.upload(file, TransferredPointDto.class);
        transferredPointService.saveAll(transferredPointMapper.toEntities(peers));
        return "redirect:all";
    }

    @GetMapping("/unload")
    public void unload(@NotNull HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"transferred_points.csv\"");
        List<TransferredPointDto> beans = transferredPointMapper.toDtos(transferredPointService.getAll());
        CsvConverter.unload(servletResponse.getWriter(), beans, TransferredPointDto.class);
    }
}

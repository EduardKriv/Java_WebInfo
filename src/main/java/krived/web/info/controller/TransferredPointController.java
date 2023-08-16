package krived.web.info.controller;

import krived.web.info.mapper.TransferredPointMapper;
import krived.web.info.model.dto.TransferredPointDto;
import krived.web.info.model.entity.TransferredPoint;
import krived.web.info.service.TransferredPointService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transferred_point")
public class TransferredPointController {
    private final TransferredPointService transferredPointService;
    private final TransferredPointMapper transferredPointMapper;

    @GetMapping("/all")
    public String allTransferredPoints(Model model) {
        List<TransferredPoint> transferredPoints = transferredPointService.getAll();
        List<TransferredPointDto> transferredPointsDtos = transferredPointMapper.toDtos(transferredPoints);
        System.out.println(transferredPointsDtos);
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
}

package krived.web.info.controller;

import krived.web.info.mapper.XpMapper;
import krived.web.info.model.dto.XpDto;
import krived.web.info.model.entity.Xp;
import krived.web.info.service.XpService;
import krived.web.info.utility.CsvConverter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/xp")
public class XpController extends GenericController<Xp, XpDto, Long> {
    @Autowired
    public XpController(XpService xpService, XpMapper xpMapper) {
        super(xpService, xpMapper, XpDto.class);
    }

    @Override
    public String create(Model model, @NotNull XpDto dto) {
        try {
            super.create(model, dto);
            return setResponseStatusAndMessage(model, "Success", "Запись обновлена");
        } catch (Exception e) {
            return setResponseStatusAndMessage(model, "Failure", "Ошибка, XP Amount не может быть больше " +
                    "максиммального и проверка должна быть успешной!");
        }
    }

    @Override
    public String update(Model model, @NotNull XpDto dto, Long id) {
        try {
            super.update(model, dto, id);
            return setResponseStatusAndMessage(model, "Success", "Запись обновлена");
        } catch (Exception e) {
            return setResponseStatusAndMessage(model, "Failure", "Ошибка, XP Amount не может быть больше " +
                    "максиммального и проверка должна быть успешной!");
        }
    }
}

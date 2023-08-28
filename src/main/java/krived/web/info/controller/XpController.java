package krived.web.info.controller;

import krived.web.info.mapper.XpMapper;
import krived.web.info.model.dto.XpDto;
import krived.web.info.model.entity.Xp;
import krived.web.info.service.XpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xp")
public class XpController extends GenericController<Xp, XpDto, Long> {

    public XpController(XpService xpService, XpMapper xpMapper) {
        super(xpService, xpMapper);
    }

    @Override
    protected Class<XpDto> getClazz() {
        return XpDto.class;
    }
}

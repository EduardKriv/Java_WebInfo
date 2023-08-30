package krived.web.info.controller;

import krived.web.info.mapper.VerterMapper;
import krived.web.info.model.dto.VerterDto;
import krived.web.info.model.entity.Verter;
import krived.web.info.service.VerterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/verter")
public class VerterController extends GenericController<Verter, VerterDto, Long>{
    @Autowired
    public VerterController(VerterService verterService, VerterMapper verterMapper) {
        super(verterService, verterMapper, VerterDto.class);
    }
}

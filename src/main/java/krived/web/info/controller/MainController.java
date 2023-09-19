package krived.web.info.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @GetMapping("/data")
    public String data() {
        return "data_block";
    }

    @GetMapping("/procedures")
    public String operation() {
        return "procedures_block";
    }
}

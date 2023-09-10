package krived.web.info.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @GetMapping("/Данные.html")
    public String data(Model model) {
        return "Данные";
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        return "Главная";
    }
}

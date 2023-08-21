package krived.web.info.controller;

import krived.web.info.model.SQLResponseBody;
import krived.web.info.service.CustomRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/custom_request")
public class CustomRequestController {
    private final CustomRequestService customRequestService;
    private SQLResponseBody table = null;

    @GetMapping("/query")
    public String execute(@RequestParam(name = "query") String query, Model model) {
        try {
            table = customRequestService.executeQuery(query);
            return setAttributes(model);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/proc/{id}")
    public String executeProc(@PathVariable Long id, Model model,
                              @RequestParam(name = "date", required = false) LocalDate date,
                              @RequestParam(name = "args", required = false) Object... args) {
//        System.out.println(date);
        try {
            table = customRequestService.executeOrCall(id, date != null ? new Object[]{date} : args);
            return setAttributes(model);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String setAttributes(Model model) {
        model.addAttribute("tableName", "requests");
        model.addAttribute("columnNames", table.getColumnNames());
        model.addAttribute("resultSet", table.getTableBody());
        return "index";
    }
}

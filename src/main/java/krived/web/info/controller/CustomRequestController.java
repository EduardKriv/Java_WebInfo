package krived.web.info.controller;

import jakarta.servlet.http.HttpServletResponse;
import krived.web.info.model.ModelCustomTable;
import krived.web.info.utility.CsvConverter;
import krived.web.info.service.CustomRequestService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CustomRequestController {
    private final CustomRequestService customRequestService;
    private ModelCustomTable customTable;

    @GetMapping("/query")
    public String execute(@RequestParam(name = "query") String query, Model model) {
        try {
            customTable = customRequestService.executeQuery(query);
            return setAttributes(model);

        } catch (SQLException e) {
            model.addAttribute("status", "Failure");
            model.addAttribute("message", "Ошибка в запросе");
            return "procedures_block";
        }
    }

    @GetMapping("/proc/{id}")
    public String executeProc(@PathVariable Long id, Model model,
                              @RequestParam(name = "date", required = false) LocalDate date,
                              @RequestParam(name = "args", required = false) Object... args) {
        try {
            customTable = customRequestService.executeOrCall(id, date != null ? new Object[]{date} : args);
            return setAttributes(model);

        } catch (SQLException e) {
            model.addAttribute("status", "Failure");
            model.addAttribute("message", "Ошибка выполнения процедуры");
            return "procedures_block";
        }
    }

    @GetMapping("/unload")
    public void unload(@NotNull HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"custom_table.csv\"");
        CsvConverter.unload(servletResponse.getWriter(), customTable);
    }

    private @NotNull String setAttributes(@NotNull Model model) {
        model.addAttribute("tableName", "requests");
        model.addAttribute("columnNames", customTable.getColumnNames());
        model.addAttribute("resultSet", customTable.getTableBody());
        return "procedures_table";
    }
}

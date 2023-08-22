package krived.web.info.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import krived.web.info.model.SQLResponseBody;
import krived.web.info.model.dto.PeerDto;
import krived.web.info.service.CustomRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

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

    @PostMapping("/upload")
    public String upload(@RequestParam(name = "file") MultipartFile file, Model model) {
//        try {
//            table = customRequestService.executeQuery(query);
//            return setAttributes(model);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<PeerDto> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(PeerDto.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<PeerDto> users = csvToBean.parse();

                // TODO: save users in DB?

                // save users list on model
                model.addAttribute("users", users);
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return setAttributes(model);
//    }


    }

    private String setAttributes(Model model) {
        model.addAttribute("tableName", "requests");
        model.addAttribute("columnNames", table.getColumnNames());
        model.addAttribute("resultSet", table.getTableBody());
        return "index";
    }
}

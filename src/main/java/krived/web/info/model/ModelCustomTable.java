package krived.web.info.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ModelCustomTable {
    private String[] columnNames;
    private List<String[]> tableBody;
}
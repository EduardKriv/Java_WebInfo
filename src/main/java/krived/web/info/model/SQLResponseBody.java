package krived.web.info.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SQLResponseBody {
    private List<String> columnNames;
    private List<List<Object>> tableBody;
}

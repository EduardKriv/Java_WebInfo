package krived.web.info.utility;

import com.opencsv.bean.CsvBindByName;
import krived.web.info.model.dto.CsvBean;

import java.util.Arrays;
import java.util.List;

public class DtoMetaData {
    public static <T extends CsvBean> List<String> getColumnNames(Class<T> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .map(field -> field.getDeclaredAnnotation(CsvBindByName.class))
                .map(CsvBindByName::column)
                .toList();
    }
}

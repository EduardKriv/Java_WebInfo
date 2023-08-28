package krived.web.info.utility;

import com.opencsv.bean.CsvBindByName;
import krived.web.info.model.dto.CsvBean;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class DtoMetaData {
    public static <T extends CsvBean> List<String> getColumnNames(@NotNull Class<T> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .map(field -> field.getDeclaredAnnotation(CsvBindByName.class))
                .map(CsvBindByName::column)
                .toList();
    }

    public static <T extends CsvBean> String getClassName(@NotNull Class<T> clazz) {
        System.out.println(clazz.getSimpleName().replaceAll("Dto", "").toLowerCase());
        return clazz.getSimpleName().replaceAll("Dto", "").toLowerCase();
    }
}

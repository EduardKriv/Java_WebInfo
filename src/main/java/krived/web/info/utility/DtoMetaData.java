package krived.web.info.utility;

import com.opencsv.bean.CsvBindByName;
import krived.web.info.model.dto.BaseDto;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class DtoMetaData {
    public static <D extends BaseDto> List<String> getColumnNames(@NotNull Class<D> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .map(field -> field.getDeclaredAnnotation(CsvBindByName.class))
                .map(CsvBindByName::column)
                .toList();
    }

    public static <D extends BaseDto> String getClassName(@NotNull Class<D> clazz) {
        return clazz.getSimpleName()
                .replaceAll("Dto", "")
                .toLowerCase();
    }
}

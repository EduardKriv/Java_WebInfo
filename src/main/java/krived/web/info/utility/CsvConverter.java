package krived.web.info.utility;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.*;
import krived.web.info.model.dto.BaseDto;
import krived.web.info.model.ModelCustomTable;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class CsvConverter {
    public static <T extends BaseDto> List<T> upload(MultipartFile file, Class<T> clazz) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CustomMappingStrategy<T> strategy = new CustomMappingStrategy<>();
            strategy.setType(clazz);

            return new CsvToBeanBuilder<T>(reader)
                    .withSkipLines(1)
                    .withMappingStrategy(strategy)
                    .withType(clazz)
                    .build()
                    .parse();
        }
        catch (Exception e) {
            throw new IOException();
        }
    }

    public static <T extends BaseDto> void unload(Writer writer, List<T> dto, Class<T> clazz) {
        try {
            CustomMappingStrategy<T> strategy = new CustomMappingStrategy<>();
            strategy.setType(clazz);

            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withOrderedResults(true)
                    .withMappingStrategy(strategy)
                    .build();

            beanToCsv.write(dto);

        }  catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void unload(Writer writ, @NotNull ModelCustomTable table) throws IOException {
        ICSVWriter writer = new CSVWriterBuilder(writ)
                .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();

        writer.writeNext(table.getColumnNames());
        writer.writeAll(table.getTableBody(), true);
        writer.close();
    }
}

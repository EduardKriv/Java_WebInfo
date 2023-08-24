package krived.web.info.service;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

@Service
public class ConvertCsvService {

    public static List<?> upload(MultipartFile file, Class<?> clazz) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            return new CsvToBeanBuilder<>(reader)
                    .withType(clazz)
                    .build()
                    .parse();

        }  catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }
}

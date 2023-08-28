package krived.web.info.service;

import krived.web.info.model.entity.Check;
import krived.web.info.repository.CheckRepository;
import krived.web.info.repository.GenericRepository;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckService extends GenericService<Check, Long> {
    @Autowired
    public CheckService(CheckRepository genericRepository) {
        super(genericRepository);
    }
}

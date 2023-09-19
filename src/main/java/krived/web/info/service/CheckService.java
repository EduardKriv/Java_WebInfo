package krived.web.info.service;

import krived.web.info.model.entity.Check;
import krived.web.info.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckService extends GenericService<Check, Long> {
    @Autowired
    public CheckService(CheckRepository genericRepository) {
        super(genericRepository);
    }
}

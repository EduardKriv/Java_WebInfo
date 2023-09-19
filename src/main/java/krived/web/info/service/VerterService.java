package krived.web.info.service;

import krived.web.info.model.entity.Verter;
import krived.web.info.repository.VerterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerterService extends GenericService<Verter, Long> {
    @Autowired
    public VerterService(VerterRepository verterRepository) {
        super(verterRepository);
    }
}

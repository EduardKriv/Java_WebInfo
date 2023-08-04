package krived.web.info.service;

import krived.web.info.model.entity.Check;
import krived.web.info.repository.CheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckService {
    private final CheckRepository checkRepository;

    public List<Check> getAll() {
        return checkRepository.findAll();
    }

    public Check getById(Long id) {
        return checkRepository.getReferenceById(id);
    }

    public Check update(Check check) {
        return checkRepository.saveAndFlush(check);
    }

    public Check create(Check check) {
        return checkRepository.saveAndFlush(check);
    }

    public void delete(Check check) {
        checkRepository.delete(check);
    }
}

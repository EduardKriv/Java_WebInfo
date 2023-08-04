package krived.web.info.service;

import krived.web.info.model.entity.Verter;
import krived.web.info.repository.VerterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VerterService {
    private final VerterRepository verterRepository;

    public List<Verter> getAll() {
        return verterRepository.findAll();
    }

    public Verter getById(Long id) {
        return verterRepository.getReferenceById(id);
    }

    public Verter update(Verter verter) {
        return verterRepository.saveAndFlush(verter);
    }

    public Verter create(Verter verter) {
        return verterRepository.saveAndFlush(verter);
    }

    public void delete(Verter verter) {
        verterRepository.delete(verter);
    }
}

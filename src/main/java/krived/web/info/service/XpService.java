package krived.web.info.service;

import krived.web.info.model.entity.Xp;
import krived.web.info.repository.XpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class XpService {
    private final XpRepository xpRepository;

    public List<Xp> getAll() {
        return xpRepository.findAll();
    }

    public Xp getById(Long id) {
        return xpRepository.getReferenceById(id);
    }

    public Xp update(Xp xp) {
        return xpRepository.saveAndFlush(xp);
    }

    public Xp create(Xp xp) {
        return xpRepository.saveAndFlush(xp);
    }

    public void delete(Xp xp) {
        xpRepository.delete(xp);
    }

    public void saveAll(List<Xp> xps) {
        xpRepository.saveAllAndFlush(xps);
    }
}

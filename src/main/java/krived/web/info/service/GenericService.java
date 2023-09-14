package krived.web.info.service;

import krived.web.info.model.entity.BaseEntity;
import krived.web.info.repository.GenericRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class GenericService<E extends BaseEntity<V>, V> {
    protected final GenericRepository<E, V> genericRepository;

    public List<E> getAll() {
        return genericRepository.findAll();
    }

    public E getById(V id) {
        return genericRepository.getReferenceById(id);
    }

    public E update(E model) {
        return genericRepository.saveAndFlush(model);
    }

    public E create(E model) {
        return genericRepository.saveAndFlush(model);
    }

    public void delete(E model) {
        genericRepository.delete(model);
    }

    public void saveAll(List<E> model) {
        genericRepository.saveAllAndFlush(model);
    }
}

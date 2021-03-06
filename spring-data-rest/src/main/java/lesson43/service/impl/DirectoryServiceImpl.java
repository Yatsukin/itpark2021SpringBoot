package lesson43.service.impl;

import lesson43.model.Directory;
import lesson43.repository.DirectoryRepository;
import lesson43.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Directory> findAllDirectory() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Directory> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Directory save(Directory directory) {
        return repository.save(directory);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

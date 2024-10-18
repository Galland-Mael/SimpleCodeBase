package mael.simplecodebase.service;

import mael.simplecodebase.model.Library;
import mael.simplecodebase.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> findAllById(List<Long> ids) {
        return libraryRepository.findAllById(ids);
    }
}

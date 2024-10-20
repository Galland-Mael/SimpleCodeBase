package mael.simplecodebase.service;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.library.LibraryCreationDTO;
import mael.simplecodebase.dto.library.LibraryDTO;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.mapper.LibraryMapper;
import mael.simplecodebase.model.Library;
import mael.simplecodebase.repository.LibraryRepository;
import mael.simplecodebase.response.BaseResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;
    private final BookService bookService;
    private final ClientService clientService;

    public LibraryService(LibraryRepository libraryRepository,
                          LibraryMapper libraryMapper,
                          @Lazy BookService bookService,
                          ClientService clientService) {
        this.libraryRepository = libraryRepository;
        this.libraryMapper = libraryMapper;
        this.bookService = bookService;
        this.clientService = clientService;
    }

    public List<Library> findAllById(List<Long> ids) {
        return libraryRepository.findAllById(ids);
    }


    public LibraryDTO create(LibraryCreationDTO library) {
        Library libraryEntity = libraryMapper.toEntity(library);
        if (library.getBooksIds() != null && !library.getBooksIds().isEmpty()) {
            libraryEntity.setBooks(this.bookService.findAllById(library.getBooksIds()));
        }
        if (library.getClientsIds() != null && !library.getClientsIds().isEmpty()) {
            libraryEntity.setClients(this.clientService.findAllById(library.getClientsIds()));
        }
        return libraryMapper.toDTO(libraryRepository.save(libraryEntity));
    }

    public BaseResponse<LibraryDTO> createBaseResponse(@Valid LibraryCreationDTO library) {
        return new BaseResponse<>(
                create(library),
                SuccesMessageEnum.BOOK_CREATED
        );
    }
}

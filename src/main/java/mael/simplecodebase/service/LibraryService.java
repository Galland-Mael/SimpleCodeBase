package mael.simplecodebase.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import mael.simplecodebase.dto.library.LibraryCreateDTO;
import mael.simplecodebase.dto.library.LibraryDTO;
import mael.simplecodebase.dto.library.LibraryUpdateDTO;
import mael.simplecodebase.exception.ApiException;
import mael.simplecodebase.exception.ErrorMessageEnum;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.mapper.LibraryMapper;
import mael.simplecodebase.model.Library;
import mael.simplecodebase.repository.LibraryRepository;
import mael.simplecodebase.response.BaseResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Library findById(@NotNull Long id) {
        Optional<Library> library = libraryRepository.findById(id);
        if (library.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, String.format(ErrorMessageEnum.LIBRARY_NOT_FOUND.getMessage(), id));
        }
        return library.get();
    }

    public Library create(LibraryCreateDTO library) {
        Library libraryEntity = libraryMapper.toEntity(library);
        this.assignBooks(libraryEntity, library.getBooksIds());
        this.assignClients(libraryEntity, library.getClientsIds());
        return libraryRepository.save(libraryEntity);
    }

    private void assignBooks(Library libraryEntity, List<Long> booksIds) {
        if (booksIds != null && !booksIds.isEmpty()) {
            libraryEntity.setBooks(this.bookService.findAllById(booksIds));
        } else {
            libraryEntity.setBooks(null);
        }
    }

    private void assignClients(Library libraryEntity, List<Long> clientsIds) {
        if (clientsIds != null && !clientsIds.isEmpty()) {
            libraryEntity.setClients(this.clientService.findAllById(clientsIds));
        } else {
            libraryEntity.setClients(null);
        }
    }

    public BaseResponse<LibraryDTO> createBaseResponse(@Valid LibraryCreateDTO library) {
        return new BaseResponse<>(
                libraryMapper.toDTO(create(library)),
                SuccesMessageEnum.LIBRARY_CREATED
        );
    }

    public BaseResponse<LibraryDTO> updateBaseResponse(Long id, @Valid LibraryUpdateDTO library) {
        return new BaseResponse<>(
                libraryMapper.toDTO(this.updateClient(id, library)),
                SuccesMessageEnum.LIBRARY_UPDATED
        );
    }

    private Library updateClient(Long id, @Valid LibraryUpdateDTO library) {
        Library libraryToUpdate = this.findById(id);
        libraryToUpdate = libraryMapper.updateEntity(libraryToUpdate, library);
        this.assignBooks(libraryToUpdate, library.getBooksIds());
        this.assignClients(libraryToUpdate, library.getClientsIds());
        return libraryRepository.save(libraryToUpdate);
    }

    public SuccesMessageEnum deleteLibrary(Long libraryId) {
        libraryRepository.deleteById(libraryId);
        return SuccesMessageEnum.LIBRARY_DELETED;
    }
}

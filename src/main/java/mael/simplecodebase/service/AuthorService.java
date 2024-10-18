package mael.simplecodebase.service;

import jakarta.validation.constraints.NotNull;
import mael.simplecodebase.dto.author.AuthorCreationDTO;
import mael.simplecodebase.dto.author.AuthorDTO;
import mael.simplecodebase.exception.ApiException;
import mael.simplecodebase.exception.ErrorMessageEnum;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.mapper.AuthorMapper;
import mael.simplecodebase.model.Author;
import mael.simplecodebase.repository.AuthorRepository;
import mael.simplecodebase.response.BaseResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final BookService bookService;

    public AuthorService(
            AuthorRepository authorRepository,
            AuthorMapper authorMapper,
            @Lazy BookService bookService
            ) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.bookService = bookService;
    }

    public AuthorDTO createAuthor(AuthorCreationDTO authorCreation) {
        Author author = authorMapper.toEntity(authorCreation);
        if(authorCreation.getBooksId() != null && !authorCreation.getBooksId().isEmpty()) {
            author.setBooks(this.bookService.findAllById(authorCreation.getBooksId()));
        }
        return authorMapper.toDTO(authorRepository.save(author));
    }

    public BaseResponse<AuthorDTO> createBaseResponse(AuthorCreationDTO author) {
        return new BaseResponse<>(
                SuccesMessageEnum.AUTHOR_CREATED,
                this.createAuthor(author)
        );
    }

    public Author findById(@NotNull Long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        if(author.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, String.format(ErrorMessageEnum.AUTHOR_NOT_FOUND.getMessage(), authorId));
        }
        return author.get();
    }
}

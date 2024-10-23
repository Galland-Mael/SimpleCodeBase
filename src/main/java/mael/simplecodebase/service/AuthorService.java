package mael.simplecodebase.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import mael.simplecodebase.dto.author.AuthorCreateDTO;
import mael.simplecodebase.dto.author.AuthorDTO;
import mael.simplecodebase.dto.author.AuthorUpdateDTO;
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

    public AuthorDTO createAuthor(AuthorCreateDTO authorCreation) {
        Author author = authorMapper.toEntity(authorCreation);
        if (authorCreation.getBooksIds() != null && !authorCreation.getBooksIds().isEmpty()) {
            author.setBooks(this.bookService.findAllById(authorCreation.getBooksIds()));
        }
        return authorMapper.toDTO(authorRepository.save(author));
    }

    public BaseResponse<AuthorDTO> createBaseResponse(AuthorCreateDTO author) {
        return new BaseResponse<>(
                this.createAuthor(author),
                SuccesMessageEnum.AUTHOR_CREATED
        );
    }

    public SuccesMessageEnum deleteAuthor(Long authorId) {
        Author author = this.findById(authorId);
        authorRepository.delete(author);
        return SuccesMessageEnum.AUTHOR_DELETED;
    }

    public Author findById(@NotNull Long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, String.format(ErrorMessageEnum.AUTHOR_NOT_FOUND.getMessage(), authorId));
        }
        return author.get();
    }

    public BaseResponse<AuthorDTO> updateBaseResponse(Long id, @Valid AuthorUpdateDTO author) {
        return new BaseResponse<>(
                this.updateAuthor(id, author),
                SuccesMessageEnum.AUTHOR_UPDATED
        );
    }

    private AuthorDTO updateAuthor(Long id, @Valid AuthorUpdateDTO author) {
        Author authorToUpdate = this.findById(id);
        authorToUpdate = authorMapper.updateEntity(authorToUpdate, author);
        if (author.getBooksIds() != null && !author.getBooksIds().isEmpty()) {
            authorToUpdate.setBooks(this.bookService.findAllById(author.getBooksIds()));
        } else {
            authorToUpdate.setBooks(null);
        }
       return authorMapper.toDTO(authorRepository.save(authorToUpdate));
    }
}

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

import java.util.List;
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

    public Author createAuthor(AuthorCreateDTO authorCreation) {
        Author author = authorMapper.toEntity(authorCreation);
        this.assignBooksToAuthor(author, authorCreation.getBooksIds());
        return authorRepository.save(author);
    }

    public BaseResponse<AuthorDTO> createBaseResponse(AuthorCreateDTO author) {
        return new BaseResponse<>(
                authorMapper.toDTO(this.createAuthor(author)),
                SuccesMessageEnum.AUTHOR_CREATED
        );
    }

    public SuccesMessageEnum deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
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
                authorMapper.toDTO(this.updateAuthor(id, author)),
                SuccesMessageEnum.AUTHOR_UPDATED
        );
    }

    private Author updateAuthor(Long id, @Valid AuthorUpdateDTO author) {
        Author authorToUpdate = this.findById(id);
        authorToUpdate = authorMapper.updateEntity(authorToUpdate, author);
        this.assignBooksToAuthor(authorToUpdate, author.getBooksIds());
       return authorRepository.save(authorToUpdate);
    }

    private void assignBooksToAuthor(Author author, List<Long> booksIds) {
        if (booksIds != null && !booksIds.isEmpty()) {
            author.setBooks(this.bookService.findAllById(booksIds));
        } else {
            author.setBooks(null);
        }
    }
}

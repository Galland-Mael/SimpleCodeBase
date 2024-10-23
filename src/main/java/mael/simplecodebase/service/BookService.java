package mael.simplecodebase.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import mael.simplecodebase.dto.book.BookCreateDTO;
import mael.simplecodebase.dto.book.BookDTO;
import mael.simplecodebase.dto.book.BookUpdateDTO;
import mael.simplecodebase.exception.ApiException;
import mael.simplecodebase.exception.ErrorMessageEnum;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.mapper.BookMapper;
import mael.simplecodebase.model.Book;
import mael.simplecodebase.repository.BookRepository;
import mael.simplecodebase.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorService authorService;
    private final LibraryService libraryService;
    private final SettingLiteraryTypeService settingLiteraryTypeService;



    public BookService(BookRepository bookRepository, BookMapper bookMapper, AuthorService authorService, LibraryService libraryService, SettingLiteraryTypeService settingLiteraryTypeService) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.authorService = authorService;
        this.libraryService = libraryService;
        this.settingLiteraryTypeService = settingLiteraryTypeService;
    }

    public List<Book> findAllById(List<Long> ids) {
        return bookRepository.findAllById(ids);
    }

    public Book findById(@NotNull Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, String.format(ErrorMessageEnum.BOOK_NOT_FOUND.getMessage(), id));
        }
        return book.get();
    }


    public Book createBook(@Valid BookCreateDTO bookCreation) {
        Book book = bookMapper.toEntity(bookCreation);
        if(bookCreation.getAuthorId() != null) {
            book.setAuthor(this.authorService.findById(bookCreation.getAuthorId()));
        }
        if(bookCreation.getSettingLiteraryType() != null) {
            book.setSettingLiteraryType(this.settingLiteraryTypeService.findByEnum(bookCreation.getSettingLiteraryType()));
        }
        this.assignLibraries(book, bookCreation.getLibrariesIds());
       return bookRepository.save(book);
    }

    public BaseResponse<BookDTO> createBaseResponse(BookCreateDTO bookCreation) {
        return new BaseResponse<>(
                this.bookMapper.toDTO(this.createBook(bookCreation)),
                SuccesMessageEnum.BOOK_CREATED
        );
    }

    public SuccesMessageEnum deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
        return SuccesMessageEnum.BOOK_DELETED;
    }

    public BaseResponse<BookDTO> updateBaseResponse(Long id, @Valid BookUpdateDTO book) {
        return new BaseResponse<>(
                bookMapper.toDTO(this.updateBook(id, book)),
                SuccesMessageEnum.BOOK_UPDATED
        );
    }

    private Book updateBook(Long id, @Valid BookUpdateDTO book) {
        Book bookToUpdate = this.findById(id);
        bookToUpdate = bookMapper.updateEntity(bookToUpdate, book);
        if(book.getAuthorId() != null && !book.getAuthorId().equals(bookToUpdate.getAuthor().getId())) {
            bookToUpdate.setAuthor(this.authorService.findById(book.getAuthorId()));
        }
        if(book.getSettingLiteraryType() != null && !book.getSettingLiteraryType().getCode().equals(bookToUpdate.getSettingLiteraryType().getCode())) {
            bookToUpdate.setSettingLiteraryType(this.settingLiteraryTypeService.findByEnum(book.getSettingLiteraryType()));
        }
        this.assignLibraries(bookToUpdate, book.getLibrariesIds());
        return bookRepository.save(bookToUpdate);
    }

    private void assignLibraries(Book book, List<Long> librariesIds) {
        if(librariesIds != null && !librariesIds.isEmpty()) {
            book.setLibraries(this.libraryService.findAllById(librariesIds));
        }
    }
}

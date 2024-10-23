package mael.simplecodebase.service;

import mael.simplecodebase.dto.book.BookCreateDTO;
import mael.simplecodebase.dto.book.BookDTO;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.mapper.BookMapper;
import mael.simplecodebase.model.Book;
import mael.simplecodebase.repository.BookRepository;
import mael.simplecodebase.response.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public BookDTO createBook(BookCreateDTO bookCreation) {
        Book book = bookMapper.toEntity(bookCreation);
        if(bookCreation.getAuthorId() != null) {
            book.setAuthor(this.authorService.findById(bookCreation.getAuthorId()));
        }
        if(bookCreation.getLibrariesIds() != null && !bookCreation.getLibrariesIds().isEmpty()) {
            book.setLibraries(this.libraryService.findAllById(bookCreation.getLibrariesIds()));
        }
        if(bookCreation.getSettingLiteraryType() != null) {
            book.setSettingLiteraryType(this.settingLiteraryTypeService.findByEnum(bookCreation.getSettingLiteraryType()));
        }
       return this.bookMapper.toDTO(bookRepository.save(book));
    }

    public BaseResponse<BookDTO> createBaseResponse(BookCreateDTO bookCreation) {
        return new BaseResponse<>(
                this.createBook(bookCreation),
                SuccesMessageEnum.BOOK_CREATED
        );
    }
}

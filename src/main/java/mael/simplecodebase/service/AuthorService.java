package mael.simplecodebase.service;

import mael.simplecodebase.dto.author.AuthorCreationDTO;
import mael.simplecodebase.dto.author.AuthorDTO;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.mapper.AuthorMapper;
import mael.simplecodebase.model.Author;
import mael.simplecodebase.repository.AuthorRepository;
import mael.simplecodebase.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final SLiteraryTypeService sLiteraryTypeService;
    private final BookService bookService;

    public AuthorService(
            AuthorRepository authorRepository,
            AuthorMapper authorMapper,
            SLiteraryTypeService sLiteraryTypeService,
            BookService bookService
            ) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.sLiteraryTypeService = sLiteraryTypeService;
        this.bookService = bookService;
    }

    public AuthorDTO createAuthor(AuthorCreationDTO authorCreation) {
        Author author = authorMapper.toEntity(authorCreation);
        if(authorCreation.getSLiteraryTypeEnum() != null) {
            author.setSLiteraryType(sLiteraryTypeService.findByEnum(authorCreation.getSLiteraryTypeEnum()));
        }
        if(authorCreation.getBooksId() != null && !authorCreation.getBooksId().isEmpty()) {
            author.setBooks(this.bookService.findAllByIds(authorCreation.getBooksId()));
        }
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toDTO(savedAuthor);
    }

    public BaseResponse<AuthorDTO> createBaseResponse(AuthorCreationDTO author) {
        return new BaseResponse<>(
                SuccesMessageEnum.AUTHOR_CREATED,
                this.createAuthor(author)
        );
    }
}

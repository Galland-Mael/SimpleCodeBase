package mael.simplecodebase.service;

import mael.simplecodebase.dto.AuthorDTO;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.mapper.AuthorMapper;
import mael.simplecodebase.model.Author;
import mael.simplecodebase.model.SLiteraryType;
import mael.simplecodebase.repository.AuthorRepository;
import mael.simplecodebase.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final SLiteraryTypeService sLiteraryTypeService;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper, SLiteraryTypeService sLiteraryTypeService) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.sLiteraryTypeService = sLiteraryTypeService;
    }

    public AuthorDTO createAuthor(AuthorDTO author) {
        Author authorEntity = authorMapper.toEntity(author);
        Author savedAuthor = authorRepository.save(authorEntity);
        return authorMapper.toDTO(savedAuthor);
    }

    public BaseResponse<AuthorDTO> createBaseResponse(AuthorDTO author) {
        return new BaseResponse<>(
                SuccesMessageEnum.AUTHOR_CREATED,
                this.createAuthor(author)
        );
    }
}

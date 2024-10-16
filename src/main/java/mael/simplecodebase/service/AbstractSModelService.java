package mael.simplecodebase.service;


import mael.simplecodebase.enumeration.CodeEnum;
import mael.simplecodebase.dto.AbstractSModelDTO;
import mael.simplecodebase.exception.ApiException;
import mael.simplecodebase.exception.ErrorMessageExceptionEnum;
import mael.simplecodebase.mapper.AbstractSModelMapper;
import mael.simplecodebase.model.AbstractSModel;
import mael.simplecodebase.repository.AbstractSModelRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public abstract class AbstractSModelService<Entity extends AbstractSModel, Dto extends AbstractSModelDTO, E extends Enum<E> & CodeEnum, Repository extends AbstractSModelRepository<Entity>, Mapper extends AbstractSModelMapper<Entity, Dto>> {

    protected Repository baseRepository;
    protected Mapper baseMapper;

    protected AbstractSModelService(Repository baseRepository, Mapper baseMapper) {
        this.baseRepository = baseRepository;
        this.baseMapper = baseMapper;
    }

    public abstract ErrorMessageExceptionEnum notFoundMessage();


    public Entity findByCode(String code) {
        Optional<Entity> entity = baseRepository.findByCode(code);
        if (entity.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, String.format(notFoundMessage().getMessage(), code));
        }
        return entity.get();
    }

    public Entity findByEnum(E enumValue) {
        return findByCode(enumValue.getCode());
    }

    public List<Entity> findAll() {
        return baseRepository.findAll();
    }

    public List<Dto> findAllInDTO() {
        return baseMapper.toListDTO(findAll());
    }

}

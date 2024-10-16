package mael.simplecodebase.service;


import mael.simplecodebase.enumeration.CodeEnum;
import mael.simplecodebase.dto.AbstractSettingModelDTO;
import mael.simplecodebase.exception.ApiException;
import mael.simplecodebase.exception.ErrorMessageEnum;
import mael.simplecodebase.mapper.AbstractSModelMapper;
import mael.simplecodebase.model.AbstractSettingModel;
import mael.simplecodebase.repository.AbstractSettingModelRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public abstract class AbstractSettingModelService<Entity extends AbstractSettingModel, Dto extends AbstractSettingModelDTO, E extends Enum<E> & CodeEnum, Repository extends AbstractSettingModelRepository<Entity>, Mapper extends AbstractSModelMapper<Entity, Dto>> {

    protected Repository baseRepository;
    protected Mapper baseMapper;

    protected AbstractSettingModelService(Repository baseRepository, Mapper baseMapper) {
        this.baseRepository = baseRepository;
        this.baseMapper = baseMapper;
    }

    public abstract ErrorMessageEnum notFoundMessage();


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

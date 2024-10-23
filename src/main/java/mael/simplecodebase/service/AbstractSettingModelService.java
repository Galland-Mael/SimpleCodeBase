package mael.simplecodebase.service;


import mael.simplecodebase.enumeration.CodeEnum;
import mael.simplecodebase.dto.AbstractSettingModelDTO;
import mael.simplecodebase.exception.ApiException;
import mael.simplecodebase.exception.ErrorMessageEnum;
import mael.simplecodebase.mapper.AbstractSModelMapper;
import mael.simplecodebase.model.AbstractSettingModel;
import mael.simplecodebase.repository.AbstractSettingModelRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public abstract class AbstractSettingModelService<M extends AbstractSettingModel, D extends AbstractSettingModelDTO, E extends Enum<E> & CodeEnum, R extends AbstractSettingModelRepository<M>, Y extends AbstractSModelMapper<M, D>> {

    protected R baseR;
    protected Y baseY;

    protected AbstractSettingModelService(R baseR, Y baseY) {
        this.baseR = baseR;
        this.baseY = baseY;
    }

    public abstract ErrorMessageEnum notFoundMessage();


    public M findByCode(String code) {
        Optional<M> entity = baseR.findByCode(code);
        if (entity.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, String.format(notFoundMessage().getMessage(), code));
        }
        return entity.get();
    }

    public M findByEnum(E enumValue) {
        return findByCode(enumValue.getCode());
    }
}

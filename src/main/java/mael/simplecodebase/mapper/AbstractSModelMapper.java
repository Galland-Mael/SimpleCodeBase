package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.AbstractSettingModelDTO;
import mael.simplecodebase.model.AbstractSettingModel;

import java.util.List;

public interface AbstractSModelMapper<E extends AbstractSettingModel,D extends AbstractSettingModelDTO> {
    E toEntity(D source);
    D toDTO(E source);
    List<E> toEntity(List<D> source);
    List<D> toListDTO(List<E> source);
}

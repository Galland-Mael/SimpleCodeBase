package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.AbstractSModelDTO;
import mael.simplecodebase.model.AbstractSModel;

import java.util.List;

public interface AbstractSModelMapper<E extends AbstractSModel,D extends AbstractSModelDTO> {
    E toEntity(D source);
    D toDTO(E source);
    List<E> toEntity(List<D> source);
    List<D> toListDTO(List<E> source);
}

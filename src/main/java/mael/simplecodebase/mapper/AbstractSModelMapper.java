package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.AbstractSModelDTO;
import mael.simplecodebase.model.AbstractSModel;

import java.util.List;

public interface AbstractSModelMapper<T extends AbstractSModel, T1 extends AbstractSModelDTO> {
    T toEntity(T1 source);
    T1 toDTO(T source);
    List<T> toEntity(List<T1> source);
    List<T1> toListDTO(List<T> source);
}

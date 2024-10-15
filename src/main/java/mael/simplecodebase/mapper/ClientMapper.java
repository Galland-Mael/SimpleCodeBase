package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.SLiteraryTypeDTO;
import mael.simplecodebase.model.SLiteraryType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface SLiteraryTypeMapper {
    SLiteraryType toEntity(SLiteraryTypeDTO sLiteraryTypeDTO);
    SLiteraryTypeDTO toDTO(SLiteraryType sLiteraryType);
}

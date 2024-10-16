package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.SettingLiteraryTypeDTO;
import mael.simplecodebase.model.SettingLiteraryType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface SettingLiteraryTypeMapper extends AbstractSModelMapper<SettingLiteraryType, SettingLiteraryTypeDTO> {
}

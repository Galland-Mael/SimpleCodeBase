package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.AuthorDTO;
import mael.simplecodebase.dto.AuthorLightDTO;
import mael.simplecodebase.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface AuthorMapper {
    // DTO
    Author toEntity(AuthorDTO source);
    AuthorDTO toDTO(Author source);
    // LightDTO
    Author toEntity(AuthorLightDTO source);
    AuthorLightDTO toLightDTO(Author source);
}

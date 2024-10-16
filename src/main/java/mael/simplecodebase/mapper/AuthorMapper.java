package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.AuthorDTO;
import mael.simplecodebase.dto.AuthorLightDTO;
import mael.simplecodebase.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {
                SLiteraryTypeMapper.class,
                BookMapper.class
        }
)
public interface AuthorMapper {
    // DTO
    Author toEntity(AuthorDTO source);
    AuthorDTO toDTO(Author source);
    // LightDTO
    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorLightDTO source);
    AuthorLightDTO toLightDTO(Author source);
}

package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.author.AuthorCreationDTO;
import mael.simplecodebase.dto.author.AuthorDTO;
import mael.simplecodebase.dto.author.AuthorLightDTO;
import mael.simplecodebase.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {
                SettingLiteraryTypeMapper.class,
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

    // AuthorCreationDTO
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorCreationDTO source);
}

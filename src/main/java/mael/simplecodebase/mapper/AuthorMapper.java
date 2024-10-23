package mael.simplecodebase.mapper;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.author.AuthorCreateDTO;
import mael.simplecodebase.dto.author.AuthorDTO;
import mael.simplecodebase.dto.author.AuthorLightDTO;
import mael.simplecodebase.dto.author.AuthorUpdateDTO;
import mael.simplecodebase.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
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
    Author toEntity(AuthorCreateDTO source);

    // AuthorUpdateDTO
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author updateEntity(@MappingTarget Author author, @Valid AuthorUpdateDTO authorUpdateDTO);
}

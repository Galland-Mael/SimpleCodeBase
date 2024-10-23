package mael.simplecodebase.mapper;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.library.LibraryCreateDTO;
import mael.simplecodebase.dto.library.LibraryDTO;
import mael.simplecodebase.dto.library.LibraryLightDTO;
import mael.simplecodebase.dto.library.LibraryUpdateDTO;
import mael.simplecodebase.model.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {
                ClientMapper.class,
                BookMapper.class
        }
)
public interface LibraryMapper {
    // DTO
    Library toEntity(LibraryDTO source);
    LibraryDTO toDTO(Library source);
    // LightDTO
    @Mapping(target = "clients", ignore = true)
    @Mapping(target = "books", ignore = true)
    Library toEntity(LibraryLightDTO source);
    LibraryLightDTO toLightDTO(Library source);
    // CreationDTO
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clients", ignore = true)
    @Mapping(target = "books", ignore = true)
    Library toEntity(LibraryCreateDTO source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clients", ignore = true)
    @Mapping(target = "books", ignore = true)
    Library updateEntity(@MappingTarget Library libraryToUpdate, @Valid LibraryUpdateDTO library);
}

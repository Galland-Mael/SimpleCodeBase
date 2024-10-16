package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.LibraryDTO;
import mael.simplecodebase.dto.LibraryLightDTO;
import mael.simplecodebase.model.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
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
}

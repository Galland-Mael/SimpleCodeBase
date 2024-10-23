package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.client.ClientCreateDTO;
import mael.simplecodebase.dto.client.ClientDTO;
import mael.simplecodebase.dto.client.ClientLightDTO;
import mael.simplecodebase.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {
                LibraryMapper.class
        }
)
public interface ClientMapper {
    // DTO
    Client toEntity(ClientDTO source);
    ClientDTO toDTO(Client source);
    // LightDTO
    @Mapping(target = "libraries", ignore = true)
    Client toEntity(ClientLightDTO source);
    ClientLightDTO toLightDTO(Client source);
    // CreationDTO
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "libraries", ignore = true)
    Client toEntity(ClientCreateDTO source);
}

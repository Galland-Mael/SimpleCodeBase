package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.ClientDTO;
import mael.simplecodebase.dto.ClientLightDTO;
import mael.simplecodebase.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ClientMapper {
    // DTO
    Client toEntity(ClientDTO source);
    ClientDTO toDTO(Client source);
    // LightDTO
    Client toEntity(ClientLightDTO source);
    ClientLightDTO toLightDTO(Client source);
}

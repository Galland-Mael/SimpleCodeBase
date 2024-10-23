package mael.simplecodebase.service;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.client.ClientCreateDTO;
import mael.simplecodebase.dto.client.ClientDTO;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.mapper.ClientMapper;
import mael.simplecodebase.model.Client;
import mael.simplecodebase.repository.ClientRepository;
import mael.simplecodebase.response.BaseResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final LibraryService libraryService;

    public ClientService(
            ClientRepository clientRepository,
            ClientMapper clientMapper,
            @Lazy LibraryService libraryService
            ) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.libraryService = libraryService;
    }

    public List<Client> findAllById(List<Long> ids) {
        return clientRepository.findAllById(ids);
    }

    public BaseResponse<ClientDTO> createBaseResponse(@Valid ClientCreateDTO client) {
        return new BaseResponse<>(
                create(client),
                SuccesMessageEnum.CLIENT_CREATED
        );
    }

    public ClientDTO create(ClientCreateDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        if(clientDTO.getLibrariesIds() != null && !clientDTO.getLibrariesIds().isEmpty()) {
            client.setLibraries(this.libraryService.findAllById(clientDTO.getLibrariesIds()));
        }
        return clientMapper.toDTO(clientRepository.save(client));
    }
}

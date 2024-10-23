package mael.simplecodebase.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import mael.simplecodebase.dto.client.ClientCreateDTO;
import mael.simplecodebase.dto.client.ClientDTO;
import mael.simplecodebase.dto.client.ClientUpdateDTO;
import mael.simplecodebase.exception.ApiException;
import mael.simplecodebase.exception.ErrorMessageEnum;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.mapper.ClientMapper;
import mael.simplecodebase.model.Client;
import mael.simplecodebase.repository.ClientRepository;
import mael.simplecodebase.response.BaseResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                clientMapper.toDTO(create(client)),
                SuccesMessageEnum.CLIENT_CREATED
        );
    }

    public Client findById(@NotNull Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, String.format(ErrorMessageEnum.CLIENT_NOT_FOUND.getMessage(), id));
        }
        return client.get();
    }

    public Client create(ClientCreateDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        this.assignLibrary(client, clientDTO.getLibrariesIds());
        return clientRepository.save(client);
    }

    private void assignLibrary(Client client, List<Long> librariesIds) {
        if(librariesIds != null && !librariesIds.isEmpty()) {
            client.setLibraries(this.libraryService.findAllById(librariesIds));
        } else {
            client.setLibraries(null);
        }
    }


    public SuccesMessageEnum deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
        return SuccesMessageEnum.CLIENT_DELETED;
    }

    public BaseResponse<ClientDTO> updateBaseResponse(Long id, @Valid ClientUpdateDTO client) {
        return new BaseResponse<>(
                clientMapper.toDTO(this.updateClient(id, client)),
                SuccesMessageEnum.CLIENT_UPDATED
        );
    }

    private Client updateClient(Long id, @Valid ClientUpdateDTO client) {
        Client clientToUpdate = this.findById(id);
        clientToUpdate = clientMapper.updateEntity(clientToUpdate, client);
        this.assignLibrary(clientToUpdate, client.getLibrariesIds());
        return clientRepository.save(clientToUpdate);
    }
}

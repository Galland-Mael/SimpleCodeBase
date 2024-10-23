package mael.simplecodebase.controller;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.client.ClientCreateDTO;
import mael.simplecodebase.dto.client.ClientDTO;
import mael.simplecodebase.response.BaseResponse;
import mael.simplecodebase.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse<ClientDTO>> create(@RequestBody @Valid ClientCreateDTO client) {
        return ResponseEntity.ok(clientService.createBaseResponse(client));
    }
}

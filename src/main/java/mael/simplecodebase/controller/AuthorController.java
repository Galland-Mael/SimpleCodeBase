package mael.simplecodebase.controller;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.author.AuthorCreationDTO;
import mael.simplecodebase.dto.author.AuthorDTO;
import mael.simplecodebase.response.BaseResponse;
import mael.simplecodebase.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AuthorDTO>> create(@RequestBody @Valid AuthorCreationDTO author) {
        return ResponseEntity.ok(this.authorService.createBaseResponse(author));
    }

}

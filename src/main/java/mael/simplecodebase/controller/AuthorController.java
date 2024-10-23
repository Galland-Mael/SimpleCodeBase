package mael.simplecodebase.controller;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.author.AuthorCreateDTO;
import mael.simplecodebase.dto.author.AuthorDTO;
import mael.simplecodebase.dto.author.AuthorUpdateDTO;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.response.BaseResponse;
import mael.simplecodebase.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<BaseResponse<AuthorDTO>> create(@RequestBody @Valid AuthorCreateDTO author) {
        return ResponseEntity.ok(this.authorService.createBaseResponse(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<AuthorDTO>> update(@PathVariable("id") Long id, @RequestBody @Valid AuthorUpdateDTO author) {
        return ResponseEntity.ok(this.authorService.updateBaseResponse(id, author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccesMessageEnum> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.authorService.deleteAuthor(id));
    }

}

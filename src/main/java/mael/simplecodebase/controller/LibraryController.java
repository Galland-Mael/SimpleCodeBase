package mael.simplecodebase.controller;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.library.LibraryCreateDTO;
import mael.simplecodebase.dto.library.LibraryDTO;
import mael.simplecodebase.response.BaseResponse;
import mael.simplecodebase.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse<LibraryDTO>> create(@RequestBody @Valid LibraryCreateDTO library) {
        return ResponseEntity.ok(libraryService.createBaseResponse(library));
    }
}

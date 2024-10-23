package mael.simplecodebase.controller;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.library.LibraryCreateDTO;
import mael.simplecodebase.dto.library.LibraryDTO;
import mael.simplecodebase.dto.library.LibraryUpdateDTO;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.response.BaseResponse;
import mael.simplecodebase.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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


    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<LibraryDTO>> update(@PathVariable("id") Long id, @RequestBody @Valid LibraryUpdateDTO library) {
        return ResponseEntity.ok(this.libraryService.updateBaseResponse(id, library));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccesMessageEnum> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.libraryService.deleteLibrary(id));
    }
}

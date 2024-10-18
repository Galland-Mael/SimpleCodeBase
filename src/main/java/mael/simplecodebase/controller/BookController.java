package mael.simplecodebase.controller;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.book.BookCreationDTO;
import mael.simplecodebase.dto.book.BookDTO;
import mael.simplecodebase.response.BaseResponse;
import mael.simplecodebase.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse<BookDTO>> create(@RequestBody @Valid BookCreationDTO book) {
        return ResponseEntity.ok(bookService.createBaseResponse(book));
    }
}

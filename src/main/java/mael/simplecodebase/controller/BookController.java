package mael.simplecodebase.controller;

import jakarta.validation.Valid;
import mael.simplecodebase.dto.book.BookCreateDTO;
import mael.simplecodebase.dto.book.BookDTO;
import mael.simplecodebase.dto.book.BookUpdateDTO;
import mael.simplecodebase.exception.SuccesMessageEnum;
import mael.simplecodebase.response.BaseResponse;
import mael.simplecodebase.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<BaseResponse<BookDTO>> create(@RequestBody @Valid BookCreateDTO book) {
        return ResponseEntity.ok(bookService.createBaseResponse(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<BookDTO>> update(@PathVariable("id") Long id, @RequestBody @Valid BookUpdateDTO book) {
        return ResponseEntity.ok(this.bookService.updateBaseResponse(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccesMessageEnum> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.bookService.deleteBook(id));
    }
}

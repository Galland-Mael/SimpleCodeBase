package mael.simplecodebase.service;

import mael.simplecodebase.mapper.BookMapper;
import mael.simplecodebase.model.Book;
import mael.simplecodebase.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<Book> findAllByIds(List<Long> ids) {
        return bookRepository.findAllById(ids);
    }
}

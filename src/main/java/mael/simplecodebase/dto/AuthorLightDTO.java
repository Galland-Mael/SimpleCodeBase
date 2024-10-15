package mael.simplecodebase.dto;

import mael.simplecodebase.model.Book;
import mael.simplecodebase.model.SLiteraryGenre;

import java.util.List;

public class AuthorDTO extends PersonneDTO {
    private Integer age;
    private SLiteraryGenre literaryGenre;
    private List<Book> books;
}

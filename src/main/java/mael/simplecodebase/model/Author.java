package mael.simplecodebase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author extends Person {
    private Integer age;
    @ManyToOne(fetch = FetchType.LAZY)
    private SLiteraryType literaryGenre;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Book> books;
}

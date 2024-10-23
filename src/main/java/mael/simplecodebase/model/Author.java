package mael.simplecodebase.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author extends Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Column(nullable = false)
    private Integer age;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author",cascade = CascadeType.DETACH)
    private List<Book> books;
}

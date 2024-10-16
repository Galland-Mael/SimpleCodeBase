package mael.simplecodebase.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
    @Column(nullable = false)
    private Integer age;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    private SettingLiteraryType settingLiteraryType;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author",cascade = CascadeType.DETACH)
    private List<Book> books;
}

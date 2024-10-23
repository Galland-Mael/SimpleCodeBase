package mael.simplecodebase.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(nullable = false)
    private LocalDate publicationDate;
    @Column(nullable = false)
    private LocalDate writtingDate;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH, optional = false)
    private SettingLiteraryType settingLiteraryType;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, optional = false)
    private Author author;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    private List<Library> libraries;
}

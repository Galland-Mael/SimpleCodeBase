package mael.simplecodebase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends Person {
    @Email
    @Column(nullable = false)
    private String email;
    @ManyToMany
    private List<Library> libraries;
}

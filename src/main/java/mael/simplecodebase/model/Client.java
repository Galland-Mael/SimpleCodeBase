package mael.simplecodebase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends Person implements Serializable {
    @Email
    @Column(nullable = false)
    private String email;
    @ManyToMany(mappedBy = "clients" , fetch = FetchType.LAZY)
    private List<Library> libraries;
}

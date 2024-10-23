package mael.simplecodebase.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.person.PersonDTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ClientCreateDTO extends PersonDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotNull
    @Email(message = "Email should be valid")
    private String email;
    private List<Long> librariesIds;
}
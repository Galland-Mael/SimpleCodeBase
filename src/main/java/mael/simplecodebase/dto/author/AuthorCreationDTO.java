package mael.simplecodebase.dto.author;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.person.PersonCreationDTO;
import mael.simplecodebase.enumeration.SLiteraryTypeEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class AuthorCreationDTO extends PersonCreationDTO {
    @NotNull
    @NotBlank
    private Integer age;
    // Here because jackson have probleme to deserialize
    @JsonProperty("sLiteraryTypeEnum")
    private SLiteraryTypeEnum sLiteraryTypeEnum;
    private List<Long> booksId;
}

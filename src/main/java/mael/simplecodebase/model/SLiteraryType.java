package mael.simplecodebase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "s_literary_type")
@Immutable
public class SLiteraryType extends AbstractSModel {
}

package mael.simplecodebase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "s_literary_genre")
@Immutable
public class SLiteraryGenre extends AbstractSModel {
}

package mael.simplecodebase.repository;

import mael.simplecodebase.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

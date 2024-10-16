package mael.simplecodebase.repository;

import mael.simplecodebase.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}

package mael.simplecodebase.repository;

import mael.simplecodebase.model.AbstractSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface AbstractSModelRepository<T extends AbstractSModel> extends JpaRepository<T, Long> {
    Optional<T> findByCode(String code);
}


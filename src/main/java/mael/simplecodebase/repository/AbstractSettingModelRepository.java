package mael.simplecodebase.repository;

import mael.simplecodebase.model.AbstractSettingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface AbstractSettingModelRepository<T extends AbstractSettingModel> extends JpaRepository<T, Long> {
    Optional<T> findByCode(String code);
}


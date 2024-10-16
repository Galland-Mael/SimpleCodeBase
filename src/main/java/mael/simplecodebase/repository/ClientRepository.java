package mael.simplecodebase.repository;

import mael.simplecodebase.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}


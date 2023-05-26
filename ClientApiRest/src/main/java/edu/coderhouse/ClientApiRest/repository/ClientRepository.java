package edu.coderhouse.ClientApiRest.repository;

import edu.coderhouse.ClientApiRest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}

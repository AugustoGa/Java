package com.augustogallo.PreEntrega1.repository;

import com.augustogallo.PreEntrega1.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client , Integer> {
}

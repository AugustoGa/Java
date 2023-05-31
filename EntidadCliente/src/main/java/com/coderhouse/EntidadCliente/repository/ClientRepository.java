package com.coderhouse.EntidadCliente.repository;

import com.coderhouse.EntidadCliente.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}

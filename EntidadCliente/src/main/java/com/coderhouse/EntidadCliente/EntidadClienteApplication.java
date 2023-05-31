package com.coderhouse.EntidadCliente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntidadClienteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EntidadClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");
	}
}

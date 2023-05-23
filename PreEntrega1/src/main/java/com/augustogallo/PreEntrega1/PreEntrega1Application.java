package com.augustogallo.PreEntrega1;

import com.augustogallo.PreEntrega1.model.Client;
import com.augustogallo.PreEntrega1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.augustogallo.PreEntrega1.repository.ClientRepository;
import com.augustogallo.PreEntrega1.repository.ProductRepository;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class PreEntrega1Application implements CommandLineRunner {//nos permite ejecutar comandos de java

	@Autowired
	private ClientRepository clientRepository; //se instancia el repository de client para poder guardar

	@Autowired
	private ProductRepository productRepository; //se instancia el repository de product para poder guardar





	public static void main(String[] args) {
		SpringApplication.run(PreEntrega1Application.class, args);
	}//dentro de este metodo se ejecutan las sentencias codigo java
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");

		//-------------------------------Producto-------------------------------
		//Armo el objeto y lo inserto en la basse
		Product taza = new Product();
		taza.setCode("1000");
		taza.setDescription("Tasa de ceramica");
		taza.setPrice(10);
		taza.setStock(100);
		this.productRepository.save(taza);//graba en la base de datos

		Product plato = new Product();
		plato.setCode("1001");
		plato.setDescription("Plato");
		plato.setPrice(50);
		plato.setStock(100);
		this.productRepository.save(plato);//graba en la base de datos

		Product tenedor = new Product();
		tenedor.setCode("1002");
		tenedor.setDescription("Tenedor ");
		tenedor.setPrice(5);
		tenedor.setStock(100);
		this.productRepository.save(tenedor);//graba en la base de datos






		//         -------------------------Cliente-------------------------------
		//Armo el objeto y lo inserto en la basse
		Client clienteUno = new Client();
		clienteUno.setName("Juan");
		clienteUno.setLastname("Gomez");
		clienteUno.setDocnumber("33323232");
		this.clientRepository.save(clienteUno);//esto graba en la base de datos

		Client clienteDos = new Client();
		clienteDos.setName("Pedro");
		clienteDos.setLastname("Garcia");
		clienteDos.setDocnumber("32326699");
		this.clientRepository.save(clienteDos);//esto graba en la base de datos

		Client clienteTres = new Client();
		clienteTres.setName("Marcelo");
		clienteTres.setLastname("Fernandez");
		clienteTres.setDocnumber("33669999");
		this.clientRepository.save(clienteTres);//esto graba en la base de datos








		//------------------select a clientes ---------------------
		List<Client> listaCliente = this.clientRepository.findAll();


		System.out.println("----------------------------------");
		System.out.println("Clientes cargados ");
		for (Client cliente : listaCliente) {//recorro la lista de objetos obtenidos de la base
			System.out.println("Nombre: " + cliente.getName());
			System.out.println("Apellido: " + cliente.getLastname());
			System.out.println("Nro Documento: $" + cliente.getDocnumber());
			System.out.println("----------------------------------");
		}
		System.out.println("Por su id");
		System.out.println("----------------------------------");
		Optional<Client> clienteObtenido = this.clientRepository.findById(1);//obtengo el cliente por su id
		if(clienteObtenido.isPresent()) System.out.println("El cliente de id :" + clienteObtenido.get() + " Existe");
		else System.out.println("El cliente no existe");



		// ------------------select a productos ---------------------
		List<Product> listaProductos = this.productRepository.findAll();

		System.out.println("productos cargado");
		System.out.println("----------------------------------");
		for (Product producto : listaProductos) {//recorro la lista de objetos obtenidos de la base
			System.out.println("Codigo: " + producto.getCode());
			System.out.println("Descripcion: " + producto.getDescription());
			System.out.println("Precio: $" + producto.getPrice());
			System.out.println("Stock: " + producto.getStock());
			System.out.println("----------------------------------");
		}
		System.out.println("Por su id");
		System.out.println("----------------------------------");
		Optional<Product> productoObtenido = this.productRepository.findById(2);//obtengo el producto por su id
		if(productoObtenido.isPresent()) System.out.println("El producto de id :" + productoObtenido.get() + " Existe");
		else System.out.println("El producto no existe");


	}
}

package com.augustogallo.PreEntrega1.repository;

import com.augustogallo.PreEntrega1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Integer> {

}

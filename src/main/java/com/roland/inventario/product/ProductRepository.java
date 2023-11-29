package com.roland.inventario.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Buscar por nombre
    //@Query("SELECT * FROM Product p WHERE p.name= ???")
    Optional<Product> findProductByName(String name);
}

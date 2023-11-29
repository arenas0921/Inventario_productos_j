package com.roland.inventario.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path= "api/v1/products")  //Exponiendo el endpoint
public class ProductController {
    //inyeccion de dependencias, el service
    private final ProductService productService;

    @Autowired  //inyectar esta clase al constructor inyeccion de dependencias
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public  List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Object> registrarProducto(@RequestBody Product product){
        return this.productService.newProduct(product);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarProducto(@RequestBody Product product){
        return this.productService.newProduct(product);
    }

    //Recibir parametros url path
    @DeleteMapping(path = "{productId}")
    public ResponseEntity<Object> eliminar( @PathVariable("productId") long id){
        return this.productService.deleteproduct(id);

    }
}

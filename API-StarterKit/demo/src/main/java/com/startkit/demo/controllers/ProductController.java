package com.startkit.demo.controllers;

import com.startkit.demo.dao.ProductDao;
import com.startkit.demo.models.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductDao productDao;

    //Dependecy Injection
    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(
            @RequestParam(required = false) @Size(min = 2) String name,
            @RequestParam(required = false) @DecimalMin("0.0") BigDecimal min,
            @RequestParam(required = false) @DecimalMin("0.0") BigDecimal max
    ) {

        //check to see if that added any params and if so, act accordingly
        if (min != null && max != null) {
            return new ResponseEntity<>(productDao.getProductsByPriceRange(min, max), HttpStatus.OK);
        } else if (name != null) {
            return new ResponseEntity<>(productDao.getProductsByName(name), HttpStatus.OK);
        } else {
            var products = productDao.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }

    //endpoint would be /products/{id}
    @GetMapping("/{id}") //variable taken from user
    public ResponseEntity<Product> getById(@PathVariable int id) {
        Product product = productDao.getProductById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    //delete products
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Product product = productDao.getProductById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean successfullyDeleted = productDao.deleteProduct(id);

        if (successfullyDeleted) {
            //204 no content
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {

        boolean created = productDao.addProduct(product);

        if (created) {
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Product product) {
        Product existing = productDao.getProductById(id);

        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        product.setProductId(id);
        boolean update = productDao.updateProduct(product);

        if (update) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

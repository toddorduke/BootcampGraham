package com.startkit.demo.controllers;

import com.startkit.demo.dao.SupplierDao;
import com.startkit.demo.models.Employee;
import com.startkit.demo.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierDao supplierDao;

@Autowired
    public SupplierController(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAll(){

        var supplier = supplierDao.getAllSuppliers();
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }
}

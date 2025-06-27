package com.startkit.demo.controllers;

import com.startkit.demo.dao.CategoryDao;
import com.startkit.demo.dao.EmployeeDao;
import com.startkit.demo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeDao employeeDao;

    //Dependecy injection
    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    //full crud

    @GetMapping
    public ResponseEntity<List<Employee>> getAtll() {
        var employees = employeeDao.getAllEmployees();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Employee employee = employeeDao.getEmployeeById(id);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Employee employee = employeeDao.getEmployeeById(id);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean succesfullyDeleted = employeeDao.deleteEmployee(id);

        if (succesfullyDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        boolean created = employeeDao.addEmployee(employee);

        if (created) {
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Employee employee){
        Employee existing = employeeDao.getEmployeeById(id);

        if(existing == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee.setEmployeeId(id);
        boolean update = employeeDao.updateEmployee(employee);

        if(update){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

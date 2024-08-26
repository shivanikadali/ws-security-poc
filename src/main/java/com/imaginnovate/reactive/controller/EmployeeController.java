package com.imaginnovate.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.reactive.entity.Employee;
import com.imaginnovate.reactive.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public Flux<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/{empid}")
    public Mono<Employee> getEmployee(@PathVariable String empid) {
        return service.getEmployee(empid);
    }

    @PostMapping
    public Mono<Employee> saveEmployee(@RequestBody Mono<Employee> employeeMono) {
        return service.saveEmployee(employeeMono);
    }
}
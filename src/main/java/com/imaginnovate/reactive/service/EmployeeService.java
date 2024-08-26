package com.imaginnovate.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.reactive.entity.Employee;
import com.imaginnovate.reactive.repo.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Flux<Employee> getEmployees() {
        return repository.findAll();
    }

    public Mono<Employee> getEmployee(String empid) {
        return repository.findById(empid);
    }

    public Mono<Employee> saveEmployee(Mono<Employee> employeeMono) {
        return employeeMono.flatMap(repository::insert);
    }
}
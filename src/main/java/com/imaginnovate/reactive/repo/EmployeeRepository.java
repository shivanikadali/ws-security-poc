package com.imaginnovate.reactive.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.reactive.entity.Employee;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

}
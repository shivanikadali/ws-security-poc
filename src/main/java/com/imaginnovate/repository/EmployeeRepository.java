package com.imaginnovate.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.dto.EmployeeDTO;

import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<EmployeeDTO, String> {
    Flux<EmployeeDTO> findByEmpid(String empid );
}

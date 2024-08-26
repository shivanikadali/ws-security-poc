package com.imaginnovate.service;

import org.springframework.stereotype.Service;

import com.imaginnovate.dto.EmployeeDTO;
import com.imaginnovate.repository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Flux<EmployeeDTO> getEmployeesByEmpid(String empid) {
        return employeeRepository.findByEmpid(empid);
    }

    public Mono<EmployeeDTO> addEmployee(EmployeeDTO employeeDTO) {
        return employeeRepository.save(employeeDTO)
        .doOnSuccess(employee -> logger.info("Employee added: {}", employee))
        .doOnError(error -> logger.error("Error adding employee", error));
    }
}


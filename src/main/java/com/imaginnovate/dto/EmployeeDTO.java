package com.imaginnovate.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "employees")
public class EmployeeDTO {
    private String empid;
    private PersonalDTO personal;
    private ProfileDTO profile;
}

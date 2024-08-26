package com.imaginnovate.reactive.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employees") // Collection name in MongoDB
public class Employee {

    @Id
    private String empid;
    private Personal personal;
    private Profile profile;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Personal {
        private String name;
        private String gender;
        private int age;
        private Address address;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address {
        private String streetaddress;
        private String city;
        private String state;
        private String postalcode;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Profile {
        private String designation;
        private String department;
    }
}
package com.imaginnovate.dto;


import lombok.Data;

    @Data
    public class PersonalDTO {
        private String name;
        private String gender;
        private int age;
        private AddressDTO address;
    }
    

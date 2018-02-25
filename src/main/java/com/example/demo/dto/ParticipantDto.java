package com.example.demo.dto;

import lombok.Data;

@Data
public class ParticipantDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private int age;
    private String emailAddress;
}

package ru.skypro.homework.dto;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Date regDate;

    private String image;

}

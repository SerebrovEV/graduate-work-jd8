package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class FullAds {
    private String authorFirstName;
    private String authorLastName;
    private String description;
    private String email;
    private String image;
    private String phone;
    private Integer id;
    private Integer price;
    private String title;
}

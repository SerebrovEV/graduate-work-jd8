package ru.skypro.homework.dto.response;

import lombok.Data;
import ru.skypro.homework.dto.User;

import java.util.List;

@Data
public class ResponseWrapperUser {
    private Integer count;
    private List<User> results;
}

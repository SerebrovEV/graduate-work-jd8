package ru.skypro.homework.dto.response;

import lombok.Data;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.User;

import java.util.List;

@Data
public class ResponseWrapperAds {
    private Integer count;
    private List<Ads> results;
}

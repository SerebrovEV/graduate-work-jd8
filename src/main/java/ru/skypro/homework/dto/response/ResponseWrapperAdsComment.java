package ru.skypro.homework.dto.response;

import lombok.Data;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.AdsComment;

import java.util.List;

@Data
public class ResponseWrapperAdsComment {
    private Integer count;
    private List<AdsComment> results;
}

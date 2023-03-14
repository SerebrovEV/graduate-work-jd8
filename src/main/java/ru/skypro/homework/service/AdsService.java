package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.dto.ResponseWrapperAds;
import ru.skypro.homework.exception.AdsNotFoundException;

public interface AdsService {

    /**
     * Добавляет новое объявление
     *
     * @param properties     {@link CreateAds}
     * @param image
     * @param authentication
     * @return Созданное объявление
     */
    Ads addAds(CreateAds properties, MultipartFile image, Authentication authentication);

    /**
     * Удаляет запись из БД по id
     *
     * @param id
     * @throws AdsNotFoundException исключение, если запись с id не найдена
     */
    void deleteAds(Integer id);

    /**
     * Изменяет объявление
     *
     * @param id
     * @param createAds
     * @return
     */
    Ads updateAds(Integer id, CreateAds createAds, Authentication authentication);

    /**
     * Получает объявление по id
     *
     * @param id
     * @return
     */
    FullAds getFullAds(Integer id);

    /**
     * Получаем все объявления
     *
     * @return
     */
    ResponseWrapperAds getAllAds();

    /**
     * Возвращает объявления конкретного пользователя
     *
     * @param authentication
     * @return
     */
    ResponseWrapperAds getAdsMe(Authentication authentication);

    /**
     * Возращает список объявлений по фильтру
     * @return
     */
    ResponseWrapperAds getAllAdsFilter(String filter);
}

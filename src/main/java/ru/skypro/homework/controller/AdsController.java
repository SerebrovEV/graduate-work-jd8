package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.service.AdsService;


@CrossOrigin(value = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdsController {

    private final AdsService adsService;


    @GetMapping
    public ResponseEntity getAllAds() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity addAds(@RequestBody String example) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity getAdsMe() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{ad_pk}/comment")
    public ResponseEntity getAdsComment(@PathVariable Long ad_pk) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{ad_pk}/comment")
    public ResponseEntity addAdsComments(@PathVariable Long ad_pk,
                                         @RequestBody String example) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{ad_pk}/comment/{id}")
    public ResponseEntity deleteAdsComment(@PathVariable Long ad_pk,
                                           @PathVariable Long id){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{ad_pk}/comment/{id}")
    public ResponseEntity getAdsComment(@PathVariable Long ad_pk,
                                        @PathVariable Long id){
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{ad_pk}/comment/{id}")
    public ResponseEntity updateAdsComment(@PathVariable Long ad_pk,
                                           @PathVariable Long id,
                                           @RequestBody String example){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeAds(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getAds(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateAds(@PathVariable Long id,
                                    @RequestBody String example) {
        return ResponseEntity.ok().build();
    }

}

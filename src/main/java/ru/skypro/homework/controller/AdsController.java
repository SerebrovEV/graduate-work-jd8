package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.service.AdsService;


@CrossOrigin(value = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdsController {

    private final AdsService adsService;


    @GetMapping
    public ResponseEntity<ResponseWrapperAds> getAllAds() {
        return ResponseEntity.ok(new ResponseWrapperAds());
    }

    @PostMapping
    public ResponseEntity<CreateAds> addAds(@RequestBody CreateAds createAds) {
        return ResponseEntity.ok(createAds);
    }

    @GetMapping("/me")
    public ResponseEntity<ResponseWrapperAds> getAdsMe(@RequestParam(value = "authenticated", required = false) boolean authenticated,
                                                       @RequestParam(value = "authorities[0].authority", required = false) String authorities0authority,
                                                       @RequestParam(value = "credentials", required = false) Object credentials,
                                                       @RequestParam(value = "details", required = false) Object details,
                                                       @RequestParam(value = "principal", required = false) Object principal) {
        return ResponseEntity.ok(new ResponseWrapperAds());
    }

    @GetMapping("/{ad_pk}/comment")
    public ResponseEntity<ResponseWrapperAdsComment> getAdsComment(@PathVariable("ad_pk") String adPk) {
        return ResponseEntity.ok(new ResponseWrapperAdsComment());
    }

    @PostMapping("/{ad_pk}/comment")
    public ResponseEntity<AdsComment> addAdsComments(@PathVariable("ad_pk") String adPk,
                                                     @RequestBody AdsComment adsComment) {
        return ResponseEntity.ok(adsComment);
    }

    @DeleteMapping("/{ad_pk}/comment/{id}")
    public ResponseEntity deleteAdsComment(@PathVariable("ad_pk") String adPk,
                                           @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{ad_pk}/comment/{id}")
    public ResponseEntity<AdsComment> getAdsComment(@PathVariable("ad_pk") String adPk,
                                                    @PathVariable Integer id) {
        return ResponseEntity.ok(new AdsComment());
    }

    @PatchMapping("/{ad_pk}/comment/{id}")
    public ResponseEntity<AdsComment> updateAdsComment(@PathVariable("ad_pk") String adPk,
                                                       @PathVariable Integer id,
                                                       @RequestBody AdsComment adsComment) {
        return ResponseEntity.ok(adsComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeAds(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FullAds> getAds(@PathVariable Integer id) {
        return ResponseEntity.ok(new FullAds());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ads> updateAds(@PathVariable Integer id,
                                         @RequestBody Ads ads) {
        return ResponseEntity.ok(ads);
    }

}

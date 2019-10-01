package com.video.service.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class VideoController {

    @GetMapping("/")
    public String getDemo() {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> webPage = rest.getForEntity("https://ketfarkukutya.mkkp.party", String.class);
        return webPage.getBody();
    }
}

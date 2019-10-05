package com.video.service.controller;

import com.video.service.service.ImbdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
public class VideoController {

    @Autowired
    private ImbdService imbdService;

    @GetMapping("/")
    public String getDemo(@RequestParam String title) throws MalformedURLException, URISyntaxException {

        return imbdService.getImbdDetails(title);
    }


}

package com.video.service.controller;

import com.video.service.model.ImbdMovieListModel;
import com.video.service.model.ImbdMovieModel;
import com.video.service.model.api.ImbdMovieApiModel;
import com.video.service.service.ImbdService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
public class VideoController {

    @Autowired
    private ImbdService imbdService;

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ImbdMovieListModel getDemo(@RequestParam String title) throws MalformedURLException, URISyntaxException {

        return imbdService.getImbdDetails(title);
    }


}

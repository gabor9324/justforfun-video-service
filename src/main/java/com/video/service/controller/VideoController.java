package com.video.service.controller;

import com.video.service.exception.ImbdApiException;
import com.video.service.model.ImbdMovieListModel;
import com.video.service.model.ImbdMovieModel;
import com.video.service.model.api.ImbdMovieApiModel;
import com.video.service.service.ImbdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
public class VideoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImbdService.class);

    @Autowired
    private ImbdService imbdService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getImbdMovieList(@RequestParam String title) {
        LOGGER.info("Search for: {}", title);

        ImbdMovieListModel imbdMovieList = imbdService.getImbdDetails(title);
        return new ResponseEntity(imbdMovieList, HttpStatus.OK);
    }


}

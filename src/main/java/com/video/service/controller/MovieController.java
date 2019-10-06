package com.video.service.controller;

import com.video.service.exception.annotation.NotEmptyRequest;
import com.video.service.model.ImbdMovieListModel;
import com.video.service.service.ImbdMovieSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImbdMovieSearchService.class);

    @Autowired
    private ImbdMovieSearchService imbdMovieSearchService;

    @GetMapping(value = "/movie/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getImbdMovieList(@RequestParam(required = true) @NotEmptyRequest String title,
                                           @RequestParam(defaultValue = "1") int page) {
        LOGGER.info("Search for: {}, page {}", title, page);

        ImbdMovieListModel imbdMovieList = imbdMovieSearchService.getImbdMovieList(title, page);
        return new ResponseEntity(imbdMovieList, HttpStatus.OK);
    }

    @GetMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getImbdMovieDetails(@RequestParam(required = true) @NotEmptyRequest String id) {
        LOGGER.info("Search for: {} movie id", id);

        String imbdMovieList = imbdMovieSearchService.getImbdMovieDetails(id);
        return new ResponseEntity(imbdMovieList, HttpStatus.OK);
    }


}

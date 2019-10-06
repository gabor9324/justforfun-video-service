package com.video.service.controller;

import com.video.service.exception.annotation.NotEmptyRequest;
import com.video.service.model.ImbdMovieListModel;
import com.video.service.service.ImbdMovieSearchService;
import org.apache.commons.lang3.StringUtils;
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

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@Validated
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImbdMovieSearchService.class);

    @Autowired
    private ImbdMovieSearchService imbdMovieSearchService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getImbdMovieList(@RequestParam(required = true) @NotEmptyRequest String title,
                                           @RequestParam(required = true) int page) {
        LOGGER.info("Search for: {}, page {}", title, page);

        ImbdMovieListModel imbdMovieList = imbdMovieSearchService.getImbdDetails(title, page);
        return new ResponseEntity(imbdMovieList, HttpStatus.OK);
    }


}

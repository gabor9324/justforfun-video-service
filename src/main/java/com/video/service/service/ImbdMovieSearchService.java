package com.video.service.service;

import com.video.service.exception.ImbdApiException;
import com.video.service.model.ImbdMovieListModel;
import com.video.service.model.api.ImbdMovieListApiModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@Service
public class ImbdMovieSearchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImbdMovieSearchService.class);

    @Autowired
    private ImbdURLCreator uriCreator;

    private final RestTemplate restTemplate = new RestTemplate();

    public ImbdMovieListModel getImbdMovieList(String title, int page) throws ImbdApiException {
        try {
            String url = uriCreator.generateImbdMovieListUrl(title, page);
            LOGGER.info("Called URL for {}:{}", title, url);
            ResponseEntity<ImbdMovieListApiModel> result = restTemplate.getForEntity(url, ImbdMovieListApiModel.class);
            return result.getBody().createImbdMovieListModel();
        } catch (MalformedURLException | URISyntaxException | HttpClientErrorException ex) {
            LOGGER.error("Cannot execute the search: ", ex);
            throw new ImbdApiException("Cannot execute the search!");
        }
    }

    public String getImbdMovieDetails(String id) throws ImbdApiException {
        try {
            String url = uriCreator.generateImbdMovieDetailsUrl(id);
            LOGGER.info("Called URL for {}", id);
            ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
            return result.getBody();
        } catch (MalformedURLException | URISyntaxException | HttpClientErrorException ex) {
            LOGGER.error("Cannot execute the search: ", ex);
            throw new ImbdApiException("Cannot execute the search!");
        }
    }


}

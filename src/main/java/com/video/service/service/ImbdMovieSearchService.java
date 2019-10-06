package com.video.service.service;

import com.video.service.exception.ImbdApiException;
import com.video.service.model.ImbdMovieListModel;
import com.video.service.model.ImbdMovieModel;
import com.video.service.model.api.ImbdMovieApiModel;
import com.video.service.model.api.ImbdMovieListApiModel;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImbdMovieSearchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImbdMovieSearchService.class);

    @Value("${imbd_api_host}")
    private String host;

    @Value("${imbd_api_key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public ImbdMovieListModel getImbdDetails(String title, int page) throws ImbdApiException {
        return queryImbdDetails(title, page).createImbdMovieListModel();
    }

    private ImbdMovieListApiModel queryImbdDetails(String title, int page) throws ImbdApiException {
        try {
            String url = generateUrl(title, page);
            LOGGER.info("Called URL for {}:{}", title, url);
            ResponseEntity<ImbdMovieListApiModel> result = restTemplate.getForEntity(url, ImbdMovieListApiModel.class);
            return result.getBody();
        } catch (MalformedURLException | URISyntaxException | HttpClientErrorException ex) {
            LOGGER.error("Cannot execute the search: ", ex);
            throw new ImbdApiException("Cannot execute the search!");
        }
    }

    private String generateUrl(String title, int page) throws MalformedURLException, URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setHost(host);
        builder.setPath("/search/movie");
        builder.addParameter("api_key", apiKey);
        builder.addParameter("query", title);
        builder.addParameter("page", page + "");
        //builder.addParameter("plot", "full");
        URL url = builder.build().toURL();

        return url.toString();
    }
}

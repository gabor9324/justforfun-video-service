package com.video.service.service;

import com.video.service.model.ImbdMovieListModel;
import com.video.service.model.ImbdMovieModel;
import com.video.service.model.api.ImbdMovieApiModel;
import com.video.service.model.api.ImbdMovieListApiModel;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class ImbdService {

    @Value("${imbd_api_host}")
    private  String host;

    @Value("${imbd_api_key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public ImbdMovieListModel getImbdDetails(String title) throws URISyntaxException, MalformedURLException {

        String url = generateUrl(title);
        ResponseEntity<ImbdMovieListApiModel> result = restTemplate.getForEntity(url, ImbdMovieListApiModel.class);

        return result.getBody().createImbdMovieListModel();
    }

    private String generateUrl(String title) throws MalformedURLException, URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setHost(host);
        builder.setPath("/3/search/movie");
        builder.addParameter("api_key", apiKey);
        builder.addParameter("query", title);
        //builder.addParameter("plot", "full");
        URL url = builder.build().toURL();

        return url.toString();
    }
}

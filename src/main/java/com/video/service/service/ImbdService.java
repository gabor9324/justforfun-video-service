package com.video.service.service;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class ImbdService {

    private static final String HOST = "www.omdbapi.com";
    private static final String API_KEY = "7fddfe85";
    private final RestTemplate restTemplate = new RestTemplate();

    public String getImbdDetails(String title) throws URISyntaxException, MalformedURLException {

        String url = generateUrl(title);
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);

        return result.getBody();
    }

    private String generateUrl(String title) throws MalformedURLException, URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setHost(HOST);
        builder.addParameter("apikey", API_KEY);
        builder.addParameter("t", title);
        builder.addParameter("plot", "full");
        URL url = builder.build().toURL();

        return url.toString();
    }
}

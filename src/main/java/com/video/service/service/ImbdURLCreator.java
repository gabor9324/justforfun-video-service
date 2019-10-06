package com.video.service.service;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Component
public class ImbdURLCreator {

    @Value("${imbd_api_host}")
    private String host;

    @Value("${imbd_api_key}")
    private String apiKey;

    public String generateImbdMovieListUrl(String title, int page) throws MalformedURLException, URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setHost(host);
        builder.setPath("/search/movie");
        builder.addParameter("api_key", apiKey);
        builder.addParameter("query", title);
        builder.addParameter("page", String.valueOf(page));
        URL url = builder.build().toURL();
        return url.toString();
    }

    public String generateImbdMovieDetailsUrl(String id) throws MalformedURLException, URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setHost(host);
        builder.setPath("/movie/" + id);
        builder.addParameter("api_key", apiKey);
        builder.addParameter("append_to_response", "videos");
        URL url = builder.build().toURL();

        return url.toString();
    }
}

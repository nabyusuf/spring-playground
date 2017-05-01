package com.example.rest;

import com.helper.MovieList;
import com.helper.Search;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by trainer3 on 4/30/17.
 */
@Service
public class MovieService {

    private final MovieConfig config;

    private final RestTemplate restTemplate = new RestTemplate();

    public MovieService(MovieConfig config) {
        this.config = config;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public ArrayList<Search> getMovieDetailsFromOMDB(String q) throws UnsupportedEncodingException {
        return this.restTemplate.getForObject(String.format("%s/?s=%s", this.config.getUrl(), q), MovieList.class).getSearch();
    }

}

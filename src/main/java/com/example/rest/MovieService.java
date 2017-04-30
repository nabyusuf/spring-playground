package com.example.rest;

import com.helper.MovieList;
import com.helper.Search;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by trainer3 on 4/30/17.
 */
@Service
public class MovieService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ArrayList<Search> getMovieDetailsFromOMDB(String q) throws UnsupportedEncodingException {
        return this.restTemplate.getForObject("http://www.omdbapi.com/?s={q}", MovieList.class, q).getSearch();

   /*     String endpointUrl = "www.omdbapi.com";
        String url = "http://{endpointUrl}/?s={q}";
        URI expanded = new UriTemplate(url).expand(endpointUrl, q);
        url = URLDecoder.decode(expanded.toString(), "UTF-8");

        RequestEntity requestEntity = RequestEntity.get(URI.create(url)).accept(MediaType.APPLICATION_JSON).build();

        System.out.println("requestEntity = [" + requestEntity + "]");

        ResponseEntity<List<Movie>> responseEntity = this.restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<Movie>>() {
                });

        System.out.println("responseEntity = [" + responseEntity.getBody() + "]");

        return responseEntity.getBody();*/

    }

}

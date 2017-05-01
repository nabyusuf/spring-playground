package com.example;

import com.example.rest.MovieService;
import com.helper.Search;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by trainer3 on 4/30/17.
 */
@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/movies",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMovies(@RequestParam("q") String q) throws UnsupportedEncodingException {
        //MovieService service = new MovieService(config);
        ArrayList<Search> response = movieService.getMovieDetailsFromOMDB(q);

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}

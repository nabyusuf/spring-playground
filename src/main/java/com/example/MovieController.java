package com.example;

import com.example.rest.MovieService;
import com.helper.MovieList;
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

    @RequestMapping(value = "/movies",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMovies(@RequestParam("q") String q) throws UnsupportedEncodingException {
        MovieService service = new MovieService();
        ArrayList<Search> result = service.getMovieDetailsFromOMDB(q);

        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

}

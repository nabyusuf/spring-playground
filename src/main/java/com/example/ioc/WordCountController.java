package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nabyusuf on 4/17/17.
 */
@RestController
public class WordCountController {

    @Autowired
    WordCounter counter;

    @PostMapping("/words/count/")
    public ResponseEntity<?> postWordCount(String input){
        Map<String, Integer> countMap = new HashMap<>();
        countMap = counter.count(input);
        return new ResponseEntity<Object>(countMap, HttpStatus.OK);
    }
}

package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer3 on 4/4/17.
 */
@RestController
@RequestMapping("/math")
public class MathPiController {

    @GetMapping("/pi")
    public String calculatePI(){
        return String.valueOf(Math.PI);
    }
}

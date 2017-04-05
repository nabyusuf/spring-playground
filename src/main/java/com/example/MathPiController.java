package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer3 on 4/4/17.
 */
/*@RestController
public class QuestionsController {
    @PostMapping("/question")
    public String getQuestion() {
        return "Nailed it!";
    }
}*/

/*@RestController
@RequestMapping("/awesome")
public class QuestionsController {
    @GetMapping("/")
    public String myMethod() {
        return "Nailed it!";
    }
}*/

/*public class QuestionsController {
    @GetMapping("/about/team")
    public String myMethod() {
        return "Nailed it!";
    }
}*/

/*
@RestController
@RequestMapping("/questions")
public class QuestionsController {
    @GetMapping("/all")
    public String myMethod() {
        return "Nailed it!";
    }
}
*/

@RestController
@RequestMapping("/questions/bysurvey")
public class QuestionsController {
    @GetMapping("/all")
    public String myMethod() {
        return "Nailed it!";
    }
}

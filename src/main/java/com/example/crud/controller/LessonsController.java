package com.example.crud.controller;

import com.example.crud.model.Lesson;
import com.example.crud.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by trainer3 on 4/9/17.
 */
@RestController
@RequestMapping("/lessons")
public class LessonsController {

    @Autowired
    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Lesson getOne(@PathVariable Long id){
        return this.repository.findOne(id);
    }

    @PatchMapping("/{id}")
    public Lesson patchRecord(@PathVariable Long id, Lesson lesson){
        return this.repository.save(lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id){
        this.repository.delete(id);
    }

}
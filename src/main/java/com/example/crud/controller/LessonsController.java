package com.example.crud.controller;

import com.example.crud.model.Lesson;
import com.example.crud.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    public Lesson patchRecord(@PathVariable Long id, @RequestBody Lesson lesson){
        Lesson lesson1 = repository.findOne(id);

        lesson1.setTitle(lesson.getTitle());
        lesson1.setDeliveredOn(lesson.getDeliveredOn());

        return this.repository.save(lesson1);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id){
        this.repository.delete(id);
    }

    @GetMapping("/find/{title}")
    public Lesson findByTitle(@PathVariable String title){
        return this.repository.findByTitle(title);
    }

    @GetMapping("/between")
    public List<Lesson> findLessonsBetweenDates(
            @RequestParam(value = "date1") @DateTimeFormat(pattern="yyyy-MM-dd")Date date1,
            @RequestParam(value = "date2") @DateTimeFormat(pattern="yyyy-MM-dd")Date date2){
        return this.repository.findLessonsBetweenDates(date1,date2);
    }
}

package com.example.crud.repository;

import com.example.crud.model.Lesson;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by trainer3 on 4/9/17.
 */
public interface LessonRepository extends CrudRepository<Lesson, Long> {
}
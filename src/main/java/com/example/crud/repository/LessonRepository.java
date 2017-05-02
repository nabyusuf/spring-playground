package com.example.crud.repository;

import com.example.crud.model.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by trainer3 on 4/9/17.
 */
public interface LessonRepository extends CrudRepository<Lesson, Long> {

    Lesson findByTitle(String title);

    String sql = "SELECT * FROM lesson WHERE deliveredon BETWEEN :date1 AND :date2";
    @Query(value = sql, nativeQuery = true)
    List<Lesson> findLessonsBetweenDates(@Param("date1") Date date1, @Param("date2") Date date2);
}
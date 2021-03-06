package com.example.crud;


import com.example.crud.model.Lesson;
import com.example.crud.repository.LessonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by trainer3 on 4/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LessonsControllerTest {

    @Autowired
    private LessonRepository repository;

    @Autowired
    MockMvc mvc;

    String requestString = "{\"id\": 5, \"title\": \"JPA\"}";

    @Test
    @Transactional
    @Rollback
    public void testPOST() throws Exception{
        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestString);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class) ));

    }

    @Test
    public void testGET() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("CNE");
        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", equalTo(lesson.getId().intValue()) ));
    }

    @Test
    public void testGETById() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("CNE");
        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons/1")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"title\":\"CNE\",\"deliveredOn\":null}"));
    }

    @Test
    public void testPatch() throws Exception {
        String requestToPatch = "{\"title\": \"Spring Security\",\"deliveredOn\": \"2017-04-12\"}";

        Lesson lesson = new Lesson();
        lesson.setTitle("CNE");
        repository.save(lesson);

        MockHttpServletRequestBuilder request = patch("/lessons/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestToPatch);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"title\":\"Spring Security\",\"deliveredOn\":\"2017-04-12\"}"));
    }

    @Test
    public void testFindByTitle() throws Exception {
        String requestPost = "{\"title\": \"SQL\",\"deliveredOn\": \"2012-06-09\"}";

        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestPost);

        this.mvc.perform(request)
                .andExpect(status().isOk());

        MockHttpServletRequestBuilder request1 = get("/lessons/find/SQL")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":5,\"title\":\"SQL\",\"deliveredOn\":\"2012-06-09\"}"));

    }

    @Test
    public void testGetInBetween() throws Exception {
        String requestString1 = "{\"id\": 1,\"title\": \"Dependency Injection\",\"deliveredOn\": \"2014-03-17\"}";
        String requestString2 = "{\"id\": 2,\"title\": \"Transactions\",\"deliveredOn\": \"2015-03-17\"}";

        MockHttpServletRequestBuilder request1 = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestString1);

        this.mvc.perform(request1)
                .andExpect(status().isOk());

        MockHttpServletRequestBuilder request2 = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestString2);

        this.mvc.perform(request2)
                .andExpect(status().isOk());

        MockHttpServletRequestBuilder request3 = get("/lessons/between?date1=2014-01-01&date2=2017-12-31")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request3)
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"title\":\"Dependency Injection\",\"deliveredOn\":\"2014-03-17\"},{\"id\":2,\"title\":\"Transactions\",\"deliveredOn\":\"2015-03-17\"}]"));
    }
}

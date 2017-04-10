package com.example.crud;

import com.example.crud.controller.LessonsController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by trainer3 on 4/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LessonsControllerTest {

    @Autowired
    LessonsController controller;

    @Test
    public void testGET() throws Exception {

    }

    @Test
    public void testPOST() throws Exception{

    }
}

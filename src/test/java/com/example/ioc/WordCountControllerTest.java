package com.example.ioc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by nabyusuf on 4/17/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(WordCountController.class)
public class WordCountControllerTest {
    
    @MockBean
    WordCountConfig config;

    @Autowired
    WordCounter counter;

    @Autowired
    MockMvc mvc;
    
    @Before
    public void setup(){
        when(config.getWordCounter()).thenReturn(new WordCounter());
    }

    @Test
    public void testPostWordCount() throws Exception {
        String input = "The brown cow jumps over the brown fox";

        this.mvc.perform(post("/words/count")
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk())
                .andExpect(content().string(""));


    }
}

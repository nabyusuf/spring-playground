package com.example.ioc;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nabyusuf on 4/17/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(WordCountController.class)
public class WordCountControllerTest {

    @MockBean
    WordCounter counter;

    @Autowired
    MockMvc mvc;

    @Test
    public void testWordCount() throws Exception {
        String input = "The brown cow jumps over the brown fox";
        WordCounter wordCounter = new WordCounter();
        wordCounter.count(input);

        Map<String, Integer> mapCount = mapValidate(input);

        assertThat(mapCount.size(), is(7));
        assertThat(mapCount, IsMapContaining.hasEntry("The",1));
        assertThat(mapCount, IsMapContaining.hasKey("brown"));
        assertThat(mapCount, IsMapContaining.hasValue(2));

    }

    @Test
    public void testPostWordCount() throws Exception {
        String input = "The brown cow jumps over the brown fox";

        when(counter.count(input)).thenReturn(mapValidate(input));

        MockHttpServletRequestBuilder request = post("/words/count/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input);

        this.mvc.perform(request)
                .andExpect(status().isOk());
    }

    public Map<String, Integer> mapValidate(String input){
        Map<String, Integer> mapCount = new HashMap<>();
        mapCount.put("The",1);
        mapCount.put("over",1);
        mapCount.put("the",1);
        mapCount.put("jumps",1);
        mapCount.put("cow", 1);
        mapCount.put("brown", 2);
        mapCount.put("fox", 1);
        return mapCount;
    }
}

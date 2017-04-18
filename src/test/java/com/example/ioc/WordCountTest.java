package com.example.ioc;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by trainer3 on 4/17/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
        "wordCount.caseSensitive=true",
        "wordCount.words.skip[0]=the",
        "wordCount.words.skip[1]=an",
        "wordCount.words.skip[2]=a",
})
public class WordCountTest {
    @Autowired
    WordCountConfigProps countConfigProps;

    @Test
    public void testWordCount() throws Exception {
        String input = "The brown cow jumps over the brown fox";

        WordCounter wordCounter = new WordCounter(countConfigProps);
        wordCounter.count(input);

        Map<String, Integer> mapCount = mapValidate(input);

        assertThat(mapCount.size(), is(7));
        assertThat(mapCount, IsMapContaining.hasEntry("The",1));
        assertThat(mapCount, IsMapContaining.hasKey("brown"));
        assertThat(mapCount, IsMapContaining.hasValue(2));

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

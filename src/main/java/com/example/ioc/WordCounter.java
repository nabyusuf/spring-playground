package com.example.ioc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nabyusuf on 4/17/17.
 */
@Service
public class WordCounter {
    private final WordCountConfigProps countConfigProps;

    public WordCounter(WordCountConfigProps countConfigProps) {
        this.countConfigProps = countConfigProps;
    }

    public Map<String,Integer> count (String input){
        Integer count = 0;
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        String[] splitString = input.split("\\s+");
        List<String> skipList = new ArrayList<>();
        skipList = countConfigProps.getWords().getSkip();
        boolean caseSensitive = countConfigProps.isCaseSensitive();

        System.out.println("skipList = [" + skipList + "]");
        for(int i=0; i<splitString.length; i++){
            if(caseSensitive == false){
                if(!(skipList.contains(splitString[i].toLowerCase()))){
                    Integer n = countMap.get(splitString[i]);
                    n = (n == null) ? 1 : ++n;
                    countMap.put(splitString[i], n);
                }
            }else{
                if(!(skipList.contains(splitString[i]))){
                    Integer n = countMap.get(splitString[i]);
                    n = (n == null) ? 1 : ++n;
                    countMap.put(splitString[i], n);
                }
            }
        }
            return countMap;
    }
/*    public Map<String,Integer> count (String input){
        Integer count = 0;
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        String[] splitString = input.split("\\s+");

        for(int i=0; i<splitString.length; i++){
                Integer n = countMap.get(splitString[i]);
                n = (n == null) ? 1 : ++n;
                countMap.put(splitString[i], n);
        }
            return countMap;
    }*/
}

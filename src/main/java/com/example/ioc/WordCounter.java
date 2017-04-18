package com.example.ioc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nabyusuf on 4/17/17.
 */
//@Component
public class WordCounter {

    public Map<String,Integer> count (String input){
        Integer count = 0;
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        String[] splitString = input.split("\\s+");

        for(int i=0; i<splitString.length; i++){

            //Map<String, Integer> map = new HashMap<>();
            //for (String w : words) {
                Integer n = countMap.get(splitString[i]);
                n = (n == null) ? 1 : ++n;
                countMap.put(splitString[i], n);
        }
        System.out.println("countMap ="+ countMap);
            return countMap;
    }
}

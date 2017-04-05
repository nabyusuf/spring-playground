package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by trainer3 on 4/5/17.
 */
@RestController
@RequestMapping("/math")
public class MathService {
    @GetMapping("/calculate")
    public String mathOperation(@RequestParam(value="operation", defaultValue = "add") String operation, @RequestParam int x, @RequestParam int y){
        String expression="";
        int result=0;

        switch(operation){
            case "add": result = x + y;
                expression = String.format("%d + %d = %d",x,y,result);
                break;
            case "subtract": result = x - y;
                expression = String.format("%d - %d = %d",x,y,result);
                break;
            case "multiply": result = x * y;
                expression = String.format("%d * %d = %d",x,y,result);
                break;
            case "divide": result = x/y;
                if(y!=0)
                    expression = String.format("%d/%d = %d",x,y,result);
                break;
            default: expression = "Invalid value";
                break;
        }
        return expression;
    }

    @PostMapping("/sum")
    public String addMultipleParameters(@RequestParam MultiValueMap<String, String> queryString){
        StringBuilder expression = new StringBuilder("");
        Integer result = 0;

        for(Map.Entry<String, List<String>> entry : queryString.entrySet()) {
            List<String> list = entry.getValue();
            Iterator<String> iter = list.iterator();
            while(iter.hasNext()){
                Integer value = Integer.valueOf(iter.next());
                expression.append(value);
                if(iter.hasNext()){
                    expression.append(" + ");
                }
                result = result + value;
            }
            expression.append(" = ").append(result);
            System.out.println("expression = [" + expression + "]");
        }
        return expression.toString();
    }
}

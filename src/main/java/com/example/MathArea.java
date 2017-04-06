package com.example;

import com.helper.Shape;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by trainer3 on 4/5/17.
 */
@RestController
@RequestMapping("/math/area")
public class MathArea {

    @PostMapping()
    public String postArea(@RequestParam Map<String, String> params){
        String result = "";

        if((params.get("type").equalsIgnoreCase("circle"))&&(params.get("radius")!=null)){
            result = String.format(
                    "Area of a %s with a radius of %s is %f",
                    params.get("type"),
                    params.get("radius"),
                    Math.PI *Integer.valueOf(params.get("radius"))*Integer.valueOf(params.get("radius"))
            );
        }

        else if((params.get("type").equalsIgnoreCase("rectangle"))&&(params.get("height")!=null)&&(params.get("width")!=null)){
            result = String.format(
                    "Area of a %sx%s %s is %d",
                    params.get("width"),
                    params.get("height"),
                    params.get("type"),
                    Integer.valueOf(params.get("width"))*Integer.valueOf(params.get("height"))
            );
        }

        else{
            result = "Invalid";
        }

        return result;
    }

    /*@PostMapping()
    public String postAreaByObject(@RequestParam Shape shape){
        String result = "";
        Double circleArea = Math.PI *Integer.valueOf(shape.getRadius())*Integer.valueOf(shape.getRadius());
        Integer rectangleArea = Integer.valueOf(shape.getWidth())*Integer.valueOf(shape.getHeight());

        if((shape.getType()).equalsIgnoreCase("circle")&&(shape.getRadius()!=null)){
            result = String.format("Area of a %s with a radius of %s is %f",shape.getType(),shape.getRadius(),circleArea);
        }

        else if((shape.getType()).equalsIgnoreCase("rectangle")&&(shape.getHeight()!=null)&&(shape.getWidth()!=null)){
            result = String.format("Area of a %sx%s %s is %d",shape.getWidth(),shape.getHeight(),rectangleArea);
        }

        else{
            result = "Invalid";
        }
        return result;
    }*/


    }
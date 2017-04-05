package com.example;

import org.springframework.web.bind.annotation.*;

/**
 * Created by trainer3 on 4/5/17.
 */
@RestController
@RequestMapping("/math/volume/{length}/{width}/{height}")
public class MathVolume {

    @PostMapping
    public String postVolume(@PathVariable int length, @PathVariable int width, @PathVariable int height){
        int volume = length*width*height;
        String result = String.format("The volume of a %dx%dx%d rectangle is %d", length, width, height, volume);

        return result;
    }

    @PatchMapping
    public String patchVolume(@PathVariable int length, @PathVariable int width, @PathVariable int height){
        int volume = length*width*height;
        String result = String.format("The volume of a %dx%dx%d rectangle is %d", length, width, height, volume);

        return result;
    }
}

package com.helper;

/**
 * Created by trainer3 on 4/5/17.
 */
public class Shape {
    public String type;
    public String radius;
    public String width;
    public String height;


    public Shape(String type, String radius) {

        this.type = type;
        this.radius = radius;
    }

    public Shape(String type, String width, String height) {

        this.type = type;
        this.width = width;
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}

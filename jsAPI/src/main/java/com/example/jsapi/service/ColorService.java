package com.example.jsapi.service;

import com.example.jsapi.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Random;

@Service
public class ColorService {
    public String randomColor(int type){
         String color = "";
        switch (type) {
            case  1:
                // Làm gì đó tại đây ...
                color = randomColorName();

                break;
            case  2:
                color = randomHexColor();
                // Làm gì đó tại đây ...
                break;
            case  3:
                color = randomRGBColor();
                break;
            default:
                throw  new BadRequestException("Type Không Hợp Lệ");
        }
        return  color;
    }
    public String randomColorName(){
        String[] colors = {"red","blue","green","yellow","pink","black"};
        Random rd = new Random();
        return  colors[rd.nextInt(colors.length)];
    }
    public String randomHexColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        String hex = Integer.toHexString(new java.awt.Color(r, g, b).getRGB() & 0xffffff);
        if (hex.length() < 6) {
            hex = "0" + hex;
        }
        hex = "#" + hex;
        return hex;
    }
    public String randomRGBColor(){
        Random rand = new Random();
        // Java 'Color' class takes 3 floats, from 0 to 1.
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return  "rgb("+r+","+g+","+b+")";
    }
}

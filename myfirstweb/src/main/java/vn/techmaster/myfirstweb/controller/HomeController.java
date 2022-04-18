package vn.techmaster.myfirstweb.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.myfirstweb.model.Book;
import vn.techmaster.myfirstweb.model.Message;

import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("hi")
    @ResponseBody
    public String hello(){
        return  "<h1>Hello World</h1><h3>Cool</h3>";
    }
    @GetMapping(value = "book",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book getBook(){
         return new Book("De Men Phuu Luu Ky","To Hoai","1945");
    }
    @GetMapping("/add/{a}/{b}")
    @ResponseBody
    public int add(@PathVariable("a") int a, @PathVariable("b") int b) {
        return a + b;
    }
    @GetMapping("/name/{your_name}")
    @ResponseBody
    public String hi(@PathVariable("your_name") String yourName) {
        return "Hi " + yourName;
    }


    @GetMapping("/year/{your_year}")
    @ResponseBody
    public int caculatorAge(@PathVariable("your_year") int yourDate) {
        Date dt= new Date();
        int year= dt.getYear();
        int current_Year=year+1900;
        return current_Year - yourDate;
    }

    @GetMapping("/random/{length}")
    @ResponseBody
    public String randomString(@PathVariable("length") int length){
        int leftLimit = 48; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    @PostMapping("/hiMessage")
    @ResponseBody
    public Message sayHi(@RequestBody Message message){
        return message;
    }

}

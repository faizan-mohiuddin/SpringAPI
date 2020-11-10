package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicLong;
import Models.*;

@RestController
public class GreetingController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(counter.incrementAndGet(), String.format(template, name));

    }

    @GetMapping("/greeting/all")
    public List<RandomDB> greetingAll(){
        // Get data from database
        Random rnd = new Random();
        // Return data
        return rnd.getAll();
    }

    @PostMapping("/greeting")
    public String greetingInsert(@RequestParam(value="ColA", defaultValue= "") String ColA, @RequestParam(value="ColB", defaultValue = "") int ColB){
        // Add row to DB
        Random rnd = new Random();
        return rnd.insert(ColA, ColB);
    }

}

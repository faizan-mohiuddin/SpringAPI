package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicLong;
import Models.*;

@RestController
public class GreetingController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/index")
    public String welcome() {

        return "index";

    }
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

    @GetMapping("/{ID}")
    public RandomDB getRow(@PathVariable(value="ID") String ID){
        // Convert string ID to int
        try{
            System.out.println("Beginning");
            System.out.println(ID);
            int id = Integer.parseInt(ID);

            Random rnd = new Random();
            return rnd.getRow(id);

        }catch(Exception e){
            System.out.println("Returning here");
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

}

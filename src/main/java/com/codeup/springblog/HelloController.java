package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller   //Always used to do something.
public class HelloController {

    @GetMapping(path = "/hello")    //GetMapping, PostMapping, RequestMapping
    @ResponseBody

    public String hello() {
        return "<h2>Hello</h>";
    }

    @GetMapping(path = "/goodbye")
    @ResponseBody

    public String goodbye() {
        return "<h1>Goodbye</h>";
    }

    //Path Variables example
    @GetMapping(path = "/hello/{name}")
    @ResponseBody

    public String helloName(@PathVariable String name) {
        return "Hi" + name;
    }

    @GetMapping(path = "/favnum/{num}")
    @ResponseBody

    public String helloName(@PathVariable int num) {
        return "My favorite num is " + num;
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody

    public String addone(@PathVariable int number) {
        return number + " plus 1 is " + (number + 1);
    }
}

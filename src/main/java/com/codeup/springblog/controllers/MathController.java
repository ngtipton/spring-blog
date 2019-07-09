package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    //Use doubles if you are working with decimals.  Also, if you are working with doubles, put a / behind the last variable.

    @GetMapping(path = "/add/{num1}/and/{num2}")
    @ResponseBody

    public String addNum(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " plus " + num2 + " equals: " + (num1 + num2);
    }

    @GetMapping(path = "/sub/{num1}/and/{num2}")
    @ResponseBody

    public String subNum(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " minus " + num2 + " equals: " + (num1 - num2);
    }

    @GetMapping(path = "/multi/{num1}/and/{num2}")
    @ResponseBody

    public String multiNum(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " times " + num2 + " equals: " + (num1 * num2);
    }

    @GetMapping(path = "/div/{num1}/and/{num2}")
    @ResponseBody

    public String divNum(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " divided by " + num2 + " equals: " + (num1 % num2);
    }

}

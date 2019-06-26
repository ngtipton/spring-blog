package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping(path = "/posts")
    @ResponseBody

    public String post() {
        return "posts index page";
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody

    public String postId(@PathVariable String id) {
        return id + "'s posts";
    }

    @GetMapping(path = "/posts/create")
    @ResponseBody

    public String getCreate() {
        return "view the form for creating a post";
    }

    @PostMapping(path = "/posts/creates")
    @ResponseBody

    public String postCreate() {
        return "view the form for creating a post";
    }

}

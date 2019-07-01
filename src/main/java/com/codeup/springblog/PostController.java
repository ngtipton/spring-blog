package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
//
//   @GetMapping(path = "/posts/show")
//
//   public String post() {
//       return "/posts/show";
//   }
//
//   @GetMapping(path = "/posts/{id}")
//
//   public String postId(@PathVariable String id) {
//       return id + "'s posts";
//   }
//
//   @GetMapping(path = "/posts/index")
//   @ResponseBody
//
//   public String getCreate() {
//       return "view the form for creating a post";
//   }

    @GetMapping("/post/show")

    public String showRollDicePage(Model viewModel) {

        List<String> ads = new ArrayList<>();

        ads.add("This is the first ad.");
        ads.add("This is the second ad.");
        ads.add("This is the third ad.");
        ads.add("This is the fourth ad.");
        ads.add("This is the fifth ad.");
        ads.add("This is the sixth ad.");
        viewModel.addAttribute("ads", ads);
        return "post/show";
    }

}

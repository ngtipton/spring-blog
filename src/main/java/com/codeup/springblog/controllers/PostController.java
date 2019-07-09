package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repos.PostRepository;
import com.codeup.springblog.repos.Users;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    // this is a dependency injection //
    private final PostRepository postRepo;

    private final Users userRepo;

    private final EmailService emailService;



    public PostController(PostRepository postRepo, Users userRepo, EmailService emailService) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String showPosts(Model model){
//        init();

        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
//        Post post = new Post();
//        post.setId(id);
//        post.setTitle("Here is post #" + post.getId());
//        post.setBody("This is not going to be a very long blog post");
        Post post = postRepo.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToSave){
        postToSave.setAuthor(userRepo.findOne(1L));
        Post savedPost = postRepo.save(postToSave);

        emailService.prepareAndSend(postToSave, "Don't point at me", "Is anyone really ever dead?  -Brody");

        return "redirect:/posts/" + savedPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post post = postRepo.findOne(id); // finding the post in the database
        model.addAttribute("post", post);
        return "posts/edit"; // this is taking them to the file path of the View
    }

    @PostMapping("/posts/{id}/edit")
    @ResponseBody
    public String editPost(@ModelAttribute Post postToEdit) {
        postToEdit.setAuthor(userRepo.findOne(1L)); // want to find the user who edited because it could be a different user every time.
//        Post post = postRepo.findOne(Long.valueOf(id));
//        post.setTitle(title);
//        post.setBody(body);
        postRepo.save(postToEdit);
        return "redirect:/posts/" + postToEdit.getId();
    }



//    private void init() {
////        List<Post> posts = new ArrayList<>();
//        Post post = new Post();
//        post.setTitle("Here is our first new post");
//        post.setBody("This is not going to be a very long blog post");
//        post.setId(4L);
//        postRepo.save(post);
//        Post post2 = new Post();
//        post2.setTitle("Here is our second new post");
//        post2.setBody("This is not going to be a very long blog post");
//        post2.setId(44L);
//        postRepo.save(post2);
//    }

}
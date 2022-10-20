package com.digitalersjava.springblog.controllers;

import com.digitalersjava.springblog.models.Post;
import com.digitalersjava.springblog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Controller
//@RestController
//@RequestMapping("/")
public class HomeController {
    @Autowired
    private PostService postService;
    @GetMapping("/")
    public String home(Model model) {
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }
}

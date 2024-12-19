package com.aqamh4.beadando.keret.controller;

import com.aqamh4.beadando.keret.entity.User;
import com.aqamh4.beadando.keret.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "home-page";
    }

    @GetMapping("/user/list")
    public String listUsers(Model model) {
        List<User> user = userService.findAll();
        model.addAttribute("user", user);
        return "user-list";
    }

    @GetMapping("/show-register-form")
    public String showRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register-form";
    }
    @PostMapping("/user/save")
    public String save(@ModelAttribute User user, Model model) {
        userService.save(user);
        model.addAttribute("user", user);
        return "redirect:/user/list";
    }
}

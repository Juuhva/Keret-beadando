package com.aqamh4.beadando.keret.controller;

import com.aqamh4.beadando.keret.entity.User;
import com.aqamh4.beadando.keret.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register-form";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login-form";
    }
        @PostMapping("/authenticate")
        public String authenticate(@RequestParam("username") String username,
                                   @RequestParam("password") String password, Model model) {
            User user = userService.findByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                return "redirect:/home-page";
            } else {
                model.addAttribute("error", "Hibás felhasználónév vagy jelszó!");
                return "login-page";
            }
        }
    @PostMapping("/user/save")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/home-page";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

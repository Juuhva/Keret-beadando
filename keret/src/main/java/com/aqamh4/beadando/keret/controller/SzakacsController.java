package com.aqamh4.beadando.keret.controller;

import com.aqamh4.beadando.keret.entity.Szakacs;
import com.aqamh4.beadando.keret.entity.User;
import com.aqamh4.beadando.keret.service.Szakacs.SzakacsService;
import com.aqamh4.beadando.keret.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SzakacsController {
    SzakacsService szakacsService;

    @Autowired
    public SzakacsController(SzakacsService szakacsService) {
        this.szakacsService = szakacsService;
    }

    @GetMapping("/add/szakacs")
    public String showAddSzakacsForm(Model model) {
        Szakacs szakacs = new Szakacs();
        model.addAttribute("szakacs", szakacs);
        return "add-szakacs";
    }

    @PostMapping("/szakacs/save")
    public String save(@ModelAttribute("szakacs") Szakacs szakacs) {
        szakacsService.save(szakacs);
        return "redirect:/";
    }
}

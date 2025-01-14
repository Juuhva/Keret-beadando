package com.aqamh4.beadando.keret.controller;

import com.aqamh4.beadando.keret.entity.Etel;
import com.aqamh4.beadando.keret.entity.Rendeles;
import com.aqamh4.beadando.keret.service.Etel.EtelService;
import com.aqamh4.beadando.keret.service.Rendeles.RendelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RendelesController {

    RendelesService rendelesService;

    @Autowired
    public RendelesController(RendelesService rendelesService) {
        this.rendelesService = rendelesService;
    }

    @GetMapping("/order")
    public String showOrderFoodForm(Model model) {
        Rendeles rendeles = new Rendeles();
        model.addAttribute("rendeles", rendeles);
        return "order-food";
    }

    @PostMapping("/order/save")
    public String save(@ModelAttribute("rendeles") Rendeles rendeles) {
        rendelesService.save(rendeles);
        return "redirect:/";
    }
}

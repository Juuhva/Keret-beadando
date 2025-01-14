package com.aqamh4.beadando.keret.controller;

import com.aqamh4.beadando.keret.entity.*;
import com.aqamh4.beadando.keret.service.Etel.EtelService;
import com.aqamh4.beadando.keret.service.Rendeles.RendelesService;
import com.aqamh4.beadando.keret.service.RendelesTeljesites.RendelesTeljesitesService;
import com.aqamh4.beadando.keret.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("orderItems")
public class RendelesController {


    RendelesService rendelesService;
    RendelesTeljesitesService rendelesTeljesitesService;
    EtelService etelService;
    UserService userService;


    @Autowired
    public RendelesController(RendelesService rendelesService,
                              RendelesTeljesitesService rendelesTeljesitesService, EtelService etelService) {
        this.rendelesService = rendelesService;
        this.rendelesTeljesitesService = rendelesTeljesitesService;
        this.etelService = etelService;
    }

    @ModelAttribute("orderItems")
    public List<Rendeles> initializeOrderItems() {
        return new ArrayList<>();
    }

    @PostMapping("/order/save")
    public String saveOrderToList(@ModelAttribute("rendeles") Rendeles rendeles,
                             @ModelAttribute("orderItems") List<Rendeles> orderItems) {
        Etel etel = etelService.findById(rendeles.getEtel().getId());
        rendeles.setEtel(etel);

        rendeles.setVegosszeg(rendeles.getMennyiseg() * etel.getEtelar());

        orderItems.add(rendeles);
        return "redirect:/order";
    }

    @PostMapping("/order/list/save")
    public String saveOrder(@ModelAttribute("rendeles") Rendeles rendeles) {
        Etel etel = etelService.findById(rendeles.getEtel().getId());
        rendeles.setEtel(etel);
        rendeles.setVegosszeg(rendeles.getMennyiseg() * etel.getEtelar());
        User user = userService.findById(rendeles.getUser().getId());
        rendeles.setUser(user);
        rendelesService.save(rendeles);
        return "redirect:/order";
    }

    @GetMapping("/order")
    public String showOrderForm(Model model) {
        Rendeles rendeles = new Rendeles();
        model.addAttribute("etelek", etelService.findAll());
        model.addAttribute("rendeles", rendeles);
        return "order-list";
    }

    @GetMapping("/order/item")
    public String showOrderItemForm(Model model) {
        Rendeles rendeles = new Rendeles();
        model.addAttribute("etelek", etelService.findAll());
        model.addAttribute("rendeles", rendeles);
        return "order-food";
    }

}

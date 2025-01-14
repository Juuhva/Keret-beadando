package com.aqamh4.beadando.keret.controller;

import com.aqamh4.beadando.keret.entity.*;
import com.aqamh4.beadando.keret.service.Etel.EtelService;
import com.aqamh4.beadando.keret.service.Rendeles.RendelesService;
import com.aqamh4.beadando.keret.service.RendelesTeljesites.RendelesTeljesitesService;
import com.aqamh4.beadando.keret.service.RendelesTetel.RendelesTetelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RendelesController {

    RendelesService rendelesService;
    RendelesTetelService rendelesTetelService;
    RendelesTeljesitesService rendelesTeljesitesService;
    EtelService etelService;


    @Autowired
    public RendelesController(RendelesService rendelesService, RendelesTetelService rendelesTetelService,
                              RendelesTeljesitesService rendelesTeljesitesService, EtelService etelService) {
        this.rendelesService = rendelesService;
        this.rendelesTetelService = rendelesTetelService;
        this.rendelesTeljesitesService = rendelesTeljesitesService;
        this.etelService = etelService;
    }

    @GetMapping("/order")
    public String showOrderForm(Model model) {
        RendelesTetel rendelesTetel = new RendelesTetel();
        model.addAttribute("etelek", etelService.findAll());
        model.addAttribute("rendelesTetel", rendelesTetel);
        return "order-list";
    }

    @GetMapping("/order/item")
    public String showOrderItemForm(Model model) {
        RendelesTetel rendelesTetel = new RendelesTetel();
        model.addAttribute("etelek", etelService.findAll());
        model.addAttribute("rendelesTetel", rendelesTetel);
        return "order-food";
    }

    @PostMapping("/order/save")
    public String save(@ModelAttribute("rendelesTetel") RendelesTetel rendelesTetel) {
        Etel etel = etelService.findById(rendelesTetel.getEtel().getId());
        rendelesTetel.setEtel(etel);
        rendelesTetelService.save(rendelesTetel);
        return "redirect:/order";
    }
}

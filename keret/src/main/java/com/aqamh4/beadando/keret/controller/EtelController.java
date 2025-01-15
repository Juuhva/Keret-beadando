package com.aqamh4.beadando.keret.controller;

import com.aqamh4.beadando.keret.entity.Etel;
import com.aqamh4.beadando.keret.entity.Szakacs;
import com.aqamh4.beadando.keret.service.Etel.EtelService;
import com.aqamh4.beadando.keret.service.Szakacs.SzakacsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EtelController {
    EtelService etelService;
    SzakacsService szakacsService;

    @Autowired
    public EtelController(EtelService etelService, SzakacsService szakacsService) {
        this.etelService = etelService;
        this.szakacsService = szakacsService;
    }

    @GetMapping("/menu")
    public String showMenu(Model model) {
        List<Etel> etelek = etelService.findAll();
        model.addAttribute("etelek", etelek);
        return "menu-list";
    }

    @GetMapping("/menu/update")
    public String showUpdadteMenu(Model model) {
        List<Etel> etelek = etelService.findAll();
        model.addAttribute("etelek", etelek);
        return "update-menu";
    }

    @GetMapping("/menu/{id}/update")
    public String showUpdateMenuForm(@PathVariable("id") int id, Model model) {
        Etel etelModositas = etelService.findById(id);
        model.addAttribute("szakacsok", szakacsService.findAll());
        model.addAttribute("etelModositas", etelModositas);
        return "update-menu";
    }

    @PostMapping("/menu/{id}/save")
    public String saveUpdatedMenu(@PathVariable("id") int id,
                                  @RequestParam("etelnev") String etelnev,
                                  @RequestParam("leiras") String leiras,
                                  @RequestParam("etelar") int etelar,
                                  @RequestParam("szakacs") int szakacsId) {
        Etel etel = etelService.findById(id);
        Szakacs szakacs = szakacsService.findById(szakacsId);

        etel.setEtelnev(etelnev);
        etel.setLeiras(leiras);
        etel.setEtelar(etelar);
        etel.setSzakacs(szakacs);

        etelService.update(etel);
        return "redirect:/menu";
    }


    @GetMapping("/add/food")
    public String showAddFoodForm(Model model) {
        Etel etel = new Etel();
        model.addAttribute("szakacsok", szakacsService.findAll());
        model.addAttribute("etel", etel);
        return "add-food";
    }

    @PostMapping("/food/save")
    public String save(@ModelAttribute("etel") Etel etel) {
        Szakacs szakacs = szakacsService.findById(etel.getSzakacs().getId());
        etel.setSzakacs(szakacs);
        etelService.save(etel);
        return "redirect:/";
    }
}

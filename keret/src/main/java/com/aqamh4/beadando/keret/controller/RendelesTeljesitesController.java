package com.aqamh4.beadando.keret.controller;

import com.aqamh4.beadando.keret.entity.Rendeles;
import com.aqamh4.beadando.keret.entity.RendelesTetel;
import com.aqamh4.beadando.keret.service.Rendeles.RendelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RendelesTeljesitesController {

    @Autowired
    private RendelesService rendelesService;

}

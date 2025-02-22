package com.aqamh4.beadando.keret.controller;

import com.aqamh4.beadando.keret.entity.*;
import com.aqamh4.beadando.keret.service.Etel.EtelService;
import com.aqamh4.beadando.keret.service.Rendeles.RendelesRepository;
import com.aqamh4.beadando.keret.service.Rendeles.RendelesService;
import com.aqamh4.beadando.keret.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("orderItems")
public class RendelesController {

    private final RendelesService rendelesService;
    private final EtelService etelService;
    private final UserService userService;

    @Autowired
    public RendelesController(RendelesService rendelesService, EtelService etelService, UserService userService) {
        this.rendelesService = rendelesService;
        this.etelService = etelService;
        this.userService = userService;
    }

    @ModelAttribute("orderItems")
    public List<RendelesTetel> initializeOrderItems() {
        return new ArrayList<>();
    }


    @PostMapping("/order/save")
    public String saveOrderItem(@ModelAttribute("rendelesTetel") RendelesTetel rendelesTetel,
                                @ModelAttribute("orderItems") List<RendelesTetel> orderItems) {
        orderItems.add(rendelesTetel);
        return "redirect:/order";
    }

    @PostMapping("/order/list/save")
    public String saveOrder(@ModelAttribute("orderItems") List<RendelesTetel> orderItems, Principal principal) {
        String userName = principal.getName();
        User user = userService.findByUsername(userName);
        Rendeles rendeles = new Rendeles();
        rendeles.setUser(user);
        orderItems.forEach(item -> item.setRendeles(rendeles));
        rendeles.setRendelesTetelek(orderItems);
        rendelesService.save(rendeles, orderItems);
        orderItems.clear();
        return "redirect:/order";
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

    @GetMapping("/order/list")
    public String showOrderList(Model model, @ModelAttribute("orderItems") List<RendelesTetel> orderItems) {
        model.addAttribute("orderItems", orderItems);
        return "order-list";
    }

    @GetMapping("/orders")
    public String listUserOrders(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String userName = userDetails.getUsername();
        User user = userService.findByUsername(userName);
        List<Rendeles> rendelesek = rendelesService.findOrderByUserId(user.getId());
        model.addAttribute("rendelesek", rendelesek);

        return "show-orders";
    }

    @GetMapping("/orders/{id}")
    public String orderDetails(@PathVariable int id, Model model) {
        Rendeles rendeles = rendelesService.findById(id);
        List<RendelesTetel> orderItems = rendelesService.findOrderById(id);

        model.addAttribute("rendeles", rendeles);
        model.addAttribute("orderItems", orderItems);

        return "order-details";
    }
}

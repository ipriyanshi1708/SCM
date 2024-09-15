package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.Userform;


@Controller
public class PageController {
    
    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page");

        //sending data to view
        model.addAttribute("name", "Priyanshi Agarwal");
        model.addAttribute("youtubeChannel", "Rapid Syntax");
        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/services")
    public String services() {
        return "services";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        Userform userform = new Userform();
        model.addAttribute("userform", userform);
        return "register";
    }

    @RequestMapping(value = "/do-register", method=RequestMethod.POST)
    public String processRegister(@ModelAttribute Userform userform) {
        System.out.println("Registering user");
        System.out.println(userform);
        return "redirect:/register";
    }
    
}

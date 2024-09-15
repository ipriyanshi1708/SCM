package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.Userform;
import com.scm.services.UserService;


@Controller
public class PageController {

    @Autowired
    private UserService userService;
    
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

        //save user
        User user = new User();
        user.setName(userform.getName());
        user.setEmail(userform.getEmail());
        user.setPassword(userform.getPassword());
        user.setAbout(userform.getAbout());
        user.setPhoneNumber(userform.getPhoneNumber());

        userService.saveUser(user);

        return "redirect:/register";
    }
    
}

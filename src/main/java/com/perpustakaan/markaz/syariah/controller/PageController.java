package com.perpustakaan.markaz.syariah.controller;

import com.perpustakaan.markaz.syariah.domain.User;
import com.perpustakaan.markaz.syariah.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by rizki on 01/06/15.
 */

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Principal principal){
        model.addAttribute("user", principal.getName());
        return "index";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "templates/signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

}

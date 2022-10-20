package com.digitalersjava.springblog.controllers;

import com.digitalersjava.springblog.models.Account;
import com.digitalersjava.springblog.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
//@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/register")
    public String getRegisterForm(Model model) {

        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }
    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute Account account) {
        accountService.save(account);
        return "redirect:/";
    }
}

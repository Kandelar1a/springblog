package com.digitalersjava.springblog.controllers;

import com.digitalersjava.springblog.models.Account;
import com.digitalersjava.springblog.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Controller
//@RestController
//@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/api/accounts")
    public List<Account> fetchAccounts() {
        return accountRepository.findAll();
    }
}

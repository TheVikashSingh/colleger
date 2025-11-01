package com.colleger.accounts.accounts_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts/")
public class AccountsController {

    @GetMapping("")
    public String getAccounts(){
        return "Accounts";
    }
}

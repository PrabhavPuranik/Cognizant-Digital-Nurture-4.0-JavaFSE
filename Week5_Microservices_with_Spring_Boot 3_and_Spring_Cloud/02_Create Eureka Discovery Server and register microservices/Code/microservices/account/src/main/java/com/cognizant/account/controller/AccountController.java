package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @GetMapping("/{number}")
    public String getAccount(@PathVariable String number) {
        return "{ \"number\": \"" + number + "\", \"type\": \"savings\", \"balance\": 234343 }";
    }
}


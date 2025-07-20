package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public String getLoan(@PathVariable String number) {
        return "{ \"number\": \"" + number + "\", \"type\": \"car\", \"loan\": 400000, \"emi\": 3258, \"tenure\": 18 }";
    }
}

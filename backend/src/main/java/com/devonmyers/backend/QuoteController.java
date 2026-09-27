package com.devonmyers.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
    @GetMapping("/api/quote")
    public String getQuote() {
        return "Discipline is choosing between what you want now and what you want most.";
    }
}

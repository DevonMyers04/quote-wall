package com.devonmyers.backend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/quotes")

public class QuoteController {
    private final List<Quote> quotes = List.of(
            new Quote(1L, "Discipline is choosing between what you want now and what you want most.", "Unknown", LocalDate.of(2026, 9, 25)),
            new Quote(2L, "Keep working after success finds you", "Serena Williams", LocalDate.of(2026, 9, 26)),
            new Quote(3L, "Great work grows through patient revision", "Hayao Miyazaki", LocalDate.of(2026, 9, 27))

    );

    @GetMapping
    public List<Quote> getAllQuotes() {
        return quotes;
    }

    @GetMapping("/{id}")
    public Quote getQuoteById(@PathVariable Long id) {
        return quotes.stream()
                .filter(quote -> quote.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Quote " + id + " not found"
                ));

    }
}

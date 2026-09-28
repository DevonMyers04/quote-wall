package com.devonmyers.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component

public class DataSeeder implements CommandLineRunner{
    private final QuoteRepository quoteRepository;

    public DataSeeder(QuoteRepository quoteRepository){
        this.quoteRepository= quoteRepository;
    }

    @Override
    public void run(String... args){
        if(quoteRepository.count()>0){
            return;
        }
        quoteRepository.saveAll(List.of(
                new Quote("Discipline is choosing between what you want now and what you want most.","Unknown", LocalDate.of(2026,9,25)),
                new Quote("Keep working after success finds you","Serena Williams",LocalDate.of(2026,9,26)),
                new Quote("Great work grows through patient revision","Hayao Miyazaki",LocalDate.of(2026,9,27))
        ));
    }
}

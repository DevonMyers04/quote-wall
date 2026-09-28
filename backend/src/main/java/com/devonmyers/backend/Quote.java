package com.devonmyers.backend;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String text;

    @Column(nullable = false)
    private String inspiredBy;

    @Column(nullable = false)
    private LocalDate writtenOn;

    protected Quote() {
    }

    public Quote(String text, String inspiredBy, LocalDate writtenOn) {
        this.text = text;
        this.inspiredBy = inspiredBy;
        this.writtenOn = writtenOn;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getInspiredBy() {
        return inspiredBy;
    }

    public LocalDate getWrittenOn() {
        return writtenOn;
    }
}
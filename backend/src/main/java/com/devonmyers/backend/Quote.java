package com.devonmyers.backend;

import java.time.LocalDate;

public record Quote(Long id, String text, String inspiredBy, LocalDate writtenOn) {

}

package com.hcorupe.contentcalender.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;


    public record Content(
            Integer id,
            @NotBlank
            String title,
            String desc,
            Status status,
            Type type,
            LocalDateTime dateCreated,
            LocalDateTime dateUpdated,
            String url
    ){}


package com.jrd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Collection;


@EntityScan
@Document(collection = "Tutorials")
public class Tutorial {
    @Id
    private long id;

    private String title;

    private boolean published;

    @JsonFormat
    @JsonSerialize
    private LocalDate checkIn;

    @JsonFormat
    @JsonSerialize
    private LocalDate checkOut;

    private int numberClicks;

}

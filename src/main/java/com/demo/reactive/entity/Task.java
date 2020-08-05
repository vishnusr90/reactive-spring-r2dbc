package com.demo.reactive.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Task {
    @Id
    private long id;

    private String description;

    private boolean completed;
}

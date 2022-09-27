package com.farukkaradeniz.rulechaining;

import com.fasterxml.jackson.annotation.JsonInclude;

public record PersonOutput(String status, @JsonInclude(JsonInclude.Include.NON_NULL) String message) {
    public PersonOutput(String status) {
        this(status, null);
    }
}

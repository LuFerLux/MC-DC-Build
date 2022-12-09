package com.luferlux.kafkaconsumer.application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StudentAvgRequest {
    private String dni;
    @JsonProperty("nombres")
    private String firstName;
    @JsonProperty("notas")
    private List<Double> notes;
    private Double average;
}

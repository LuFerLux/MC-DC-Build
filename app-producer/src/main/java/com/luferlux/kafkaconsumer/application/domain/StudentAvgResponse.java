package com.luferlux.kafkaconsumer.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentAvgResponse {
    private Boolean success;
    private String message;
}

package com.luferlux.kafkaconsumer.application.port.in;

import com.luferlux.kafkaconsumer.application.domain.StudentAvgRequest;
import com.luferlux.kafkaconsumer.application.domain.StudentAvgResponse;

public interface StudentPortIn {
    void consume(StudentAvgRequest request);

    StudentAvgResponse findById(String dni);
}

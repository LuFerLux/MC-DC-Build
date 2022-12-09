package com.luferlux.kafkaconsumer.application.port.in;

import com.luferlux.kafkaconsumer.application.domain.StudentAvgRequest;
import com.luferlux.kafkaconsumer.application.domain.StudentAvgResponse;

public interface StudentPortIn {
    StudentAvgResponse calcAverage(StudentAvgRequest request);
}

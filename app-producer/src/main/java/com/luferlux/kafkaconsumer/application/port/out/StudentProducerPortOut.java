package com.luferlux.kafkaconsumer.application.port.out;

import com.luferlux.kafkaconsumer.application.domain.StudentAvgRequest;

public interface StudentProducerPortOut {
    void produce(String topic, StudentAvgRequest request);
}

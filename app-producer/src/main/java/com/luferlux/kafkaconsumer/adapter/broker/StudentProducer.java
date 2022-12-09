package com.luferlux.kafkaconsumer.adapter.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luferlux.kafkaconsumer.application.domain.StudentAvgRequest;
import com.luferlux.kafkaconsumer.application.port.out.StudentProducerPortOut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentProducer implements StudentProducerPortOut {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void produce(String topic, StudentAvgRequest request) {
        String message = "";
        try {
            message = objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info("[START] Send to kafka: topic={}, message={}", topic, message);
        kafkaTemplate.send(topic, null, message);
        log.info("[END] Send to kafka ");
    }
}

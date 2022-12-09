package com.luferlux.kafkaconsumer.adapter.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luferlux.kafkaconsumer.application.domain.StudentAvgRequest;
import com.luferlux.kafkaconsumer.application.port.in.StudentPortIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StudentAvgListener {
    @Value("${students.topics.average}")
    String topic;

    @Autowired
    private StudentPortIn studentPortIn;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${students.topics.average}")
    public void listen(
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset,
            @Payload String message
    ) throws JsonProcessingException {
        log.info("[START] {} from partition-{} with offset-{} message=[{}]", topic, message, partition, offset);

        StudentAvgRequest request = objectMapper.readValue(message, StudentAvgRequest.class);

        studentPortIn.consume(request);

        log.info("[END] {}", topic);
    }
}

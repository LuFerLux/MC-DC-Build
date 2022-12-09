package com.luferlux.kafkaconsumer.application.usecase;

import com.luferlux.kafkaconsumer.application.domain.StudentAvgRequest;
import com.luferlux.kafkaconsumer.application.domain.StudentAvgResponse;
import com.luferlux.kafkaconsumer.application.port.in.StudentPortIn;
import com.luferlux.kafkaconsumer.application.port.out.StudentProducerPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@RequiredArgsConstructor
public class StudentUseCase implements StudentPortIn {
    private final StudentProducerPortOut studentProducerPortOut;
    @Value("${students.topics.average}")
    private String topic;

    @Override
    public StudentAvgResponse calcAverage(StudentAvgRequest request) {
        double average = request.getNotes().stream().reduce(0d, (a, b) -> a + b) / request.getNotes().size();
        request.setAverage((double) Math.round(average * 100) / 100);

        studentProducerPortOut.produce(topic, request);

        return StudentAvgResponse.builder()
                .success(true)
                .message("OK")
                .build();
    }
}

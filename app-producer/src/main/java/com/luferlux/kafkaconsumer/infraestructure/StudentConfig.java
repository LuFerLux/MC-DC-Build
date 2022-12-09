package com.luferlux.kafkaconsumer.infraestructure;

import com.luferlux.kafkaconsumer.application.port.out.StudentProducerPortOut;
import com.luferlux.kafkaconsumer.application.usecase.StudentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public StudentUseCase studentUseCase(StudentProducerPortOut studentProducerPortOut) {
        return new StudentUseCase(studentProducerPortOut);
    }
}

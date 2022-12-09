package com.luferlux.kafkaconsumer.infraestructure;

//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.luferlux.kafkaconsumer.application.port.in.StudentPersistence;
import com.luferlux.kafkaconsumer.application.usecase.StudentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public StudentUseCase studentUseCase(StudentPersistence studentPersistence) {
        return new StudentUseCase(studentPersistence);
    }
//    @Bean
//    public ObjectMapper objectMapper() {
//        return new ObjectMapper()
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//    }
}

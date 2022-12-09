package com.luferlux.kafkaconsumer.adapter.rest.out;

import com.luferlux.kafkaconsumer.application.domain.StudentAvgResponse;
import com.luferlux.kafkaconsumer.application.port.in.StudentPortIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/students")
public class StudentController {
    @Autowired
    private StudentPortIn studentPortIn;

    @GetMapping("{dni}")
    public ResponseEntity<StudentAvgResponse> get(@PathVariable("dni") String dni) {
        try {
            log.info("[START] [POST] /students/{}", dni);
            return ResponseEntity.ok(studentPortIn.findById(dni));
        } finally {
            log.info("[END] [POST] /students/{}", dni);
        }
    }
}

package com.luferlux.kafkaconsumer.adapter.rest.out;

import com.luferlux.kafkaconsumer.application.domain.StudentAvgRequest;
import com.luferlux.kafkaconsumer.application.domain.StudentAvgResponse;
import com.luferlux.kafkaconsumer.application.port.in.StudentPortIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/students")
public class StudentController {
    @Autowired
    private  StudentPortIn studentPortIn;

    @GetMapping
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("OK");
    }

    @PostMapping("calc-average")
    public ResponseEntity<StudentAvgResponse> calcAverage(@RequestBody @Valid StudentAvgRequest request) {
        try {
            log.info("[START] [POST] /students/calc-average {}", request);
            return ResponseEntity.ok(studentPortIn.calcAverage(request));
        } finally {
            log.info("[END] [POST] /students/calc-average {}", request);
        }
    }
}

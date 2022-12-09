package com.luferlux.kafkaconsumer.adapter.persistence;

import com.luferlux.kafkaconsumer.adapter.persistence.repository.StudentRepository;
import com.luferlux.kafkaconsumer.adapter.persistence.table.Student;
import com.luferlux.kafkaconsumer.application.port.in.StudentPersistence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentAdapter implements StudentPersistence {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findByDni(String dni) {
        return studentRepository.findById(dni).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}

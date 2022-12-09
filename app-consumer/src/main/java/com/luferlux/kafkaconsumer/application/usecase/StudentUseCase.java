package com.luferlux.kafkaconsumer.application.usecase;

import com.luferlux.kafkaconsumer.adapter.persistence.table.Student;
import com.luferlux.kafkaconsumer.application.domain.StudentAvgRequest;
import com.luferlux.kafkaconsumer.application.domain.StudentAvgResponse;
import com.luferlux.kafkaconsumer.application.port.in.StudentPersistence;
import com.luferlux.kafkaconsumer.application.port.in.StudentPortIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
public class StudentUseCase implements StudentPortIn {
    private final StudentPersistence studentPersistence;

    @Override
    public void consume(StudentAvgRequest request) {
        Student student = studentPersistence.findByDni(request.getDni());

        if (student == null) {
            student = new Student();
            student.setDni(request.getDni());
        }

        student.setFirstName(request.getFirstName());
        for (int i = 0; i < request.getNotes().size(); i++) {
            switch (i) {
                case 0:
                    student.setNote1(request.getNotes().get(i));
                    break;
                case 1:
                    student.setNote2(request.getNotes().get(i));
                    break;
                case 2:
                    student.setNote3(request.getNotes().get(i));
                    break;
                case 3:
                    student.setNote4(request.getNotes().get(i));
                    break;
            }
        }

        double average = request.getNotes().stream().reduce(0d, (a, b) -> a + b) / request.getNotes().size();

        student.setAverage((double) Math.round(average * 100) / 100);

        studentPersistence.save(student);
    }

    @Override
    public StudentAvgResponse findById(String dni) {
        StudentAvgResponse response = null;

        Student student = studentPersistence.findByDni(dni);

        if (student != null) {
            response = new StudentAvgResponse();
            response.setDni(dni);
            response.setFirstName(student.getFirstName());
            response.setAverage(student.getAverage());

            response.setNotes(new ArrayList<>());

            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        response.getNotes().add(student.getNote1());
                        break;
                    case 1:
                        response.getNotes().add(student.getNote2());
                        break;
                    case 2:
                        response.getNotes().add(student.getNote3());
                        break;
                    case 3:
                        response.getNotes().add(student.getNote4());
                        break;
                }
            }
        }

        return response;
    }
}

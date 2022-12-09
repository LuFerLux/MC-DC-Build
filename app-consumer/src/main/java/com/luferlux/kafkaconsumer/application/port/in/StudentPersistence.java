package com.luferlux.kafkaconsumer.application.port.in;

import com.luferlux.kafkaconsumer.adapter.persistence.table.Student;

public interface StudentPersistence {
    Student findByDni(String dni);

    Student save(Student student);
}

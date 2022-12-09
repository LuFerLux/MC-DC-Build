package com.luferlux.kafkaconsumer.adapter.persistence.repository;

import com.luferlux.kafkaconsumer.adapter.persistence.table.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
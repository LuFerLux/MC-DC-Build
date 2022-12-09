package com.luferlux.kafkaconsumer.adapter.persistence.table;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    private String dni;

    @Column(name = "nombres")
    private String firstName;

    @Column(name = "nota1")
    private Double note1;

    @Column(name = "nota2")
    private Double note2;

    @Column(name = "nota3")
    private Double note3;

    @Column(name = "nota4")
    private Double note4;

    @Column(name = "promedio")
    private Double average;
}

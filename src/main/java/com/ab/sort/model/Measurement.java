package com.ab.sort.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "measurement")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String measurementUnit;
    private String symbol;
}

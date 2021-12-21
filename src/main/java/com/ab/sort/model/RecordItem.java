package com.ab.sort.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "record_item")
public class RecordItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    private String itemName;
    private int unitPrice;
    private int unitDiscount;
    private int NumberOfUnits;

    @ManyToOne
    @JoinColumn(name = "record_id",nullable = false)
    private Record record;

}

package com.ab.sort.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreationTimestamp
    private Date timestamp;
    private float totalAmount;
    private float couponDiscount;
    private float totalDiscount;
    private float billingAmount;
    private String type;
    @OneToMany(mappedBy = "record")
    @ToString.Exclude
    private Set<RecordItem> recordItems;
}

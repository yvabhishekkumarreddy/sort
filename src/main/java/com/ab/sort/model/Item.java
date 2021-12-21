package com.ab.sort.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "items")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    private String itemName;
    @NotNull
    private String itemType;
    private String itemDescription;
    private float quantityLeft;
    private String imageUrl;
    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;
    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;
    @ManyToOne(optional = false)
    @JoinColumn(name = "measurement_id", nullable = false)
    private Measurement measurement;
    @ManyToOne(optional = false)
    @JoinColumn(name = "item_category_id", nullable = false)
    private ItemCategory itemCategory;

}

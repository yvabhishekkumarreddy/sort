package com.ab.sort.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddItemDto {
    private String itemName;
    private String itemType;
    private String itemDescription;
    private float quantityLeft;
    private String itemCategory;
    private String measurement;
}

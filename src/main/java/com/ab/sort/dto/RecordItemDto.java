package com.ab.sort.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordItemDto {
    private String itemName;
    private int unitPrice;
    private int unitDiscount;
    private int numberOfUnits;
}

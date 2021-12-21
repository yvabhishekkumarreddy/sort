package com.ab.sort.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecordDto {
    private String type;
    private int couponDiscount;
    private Set<RecordItemDto> recordItems;
}

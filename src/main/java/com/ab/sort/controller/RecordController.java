package com.ab.sort.controller;

import com.ab.sort.dao.RecordItemRepo;
import com.ab.sort.dao.RecordRepo;
import com.ab.sort.dto.CreateRecordDto;
import com.ab.sort.mapper.RecordMapper;
import com.ab.sort.model.Record;
import com.ab.sort.model.RecordItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class RecordController {
    @Autowired
    private RecordRepo recordRepo;
    @Autowired
    private RecordItemRepo recordItemRepo;
    @Autowired
    private RecordMapper recordMapper;

    @PostMapping("/createRecord")
    public String createRecord(@RequestBody CreateRecordDto createRecordDto){
        Record record = recordMapper.mapDtoTo(createRecordDto);
        recordRepo.save(record);
        int amount = 0;
        int discount = 0;
        Set<RecordItem> recordItems = record.getRecordItems();
        for (RecordItem r: recordItems) {
            r.setRecord(record);
            amount += r.getUnitPrice() * r.getNumberOfUnits() ;
            discount += r.getUnitDiscount() * r.getNumberOfUnits();
            recordItemRepo.save(r);
        }
        System.out.println("discount "+ discount);
        record.setTotalAmount(amount);
        discount += record.getCouponDiscount();
        System.out.println(record.getCouponDiscount());
        System.out.println("Total discount "+ discount);
        record.setTotalDiscount(discount);
        record.setBillingAmount(amount-discount);
        recordRepo.save(record);
        return record.toString();
    }
}

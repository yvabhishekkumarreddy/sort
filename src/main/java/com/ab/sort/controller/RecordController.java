package com.ab.sort.controller;

import com.ab.sort.dao.RecordItemRepo;
import com.ab.sort.dao.RecordRepo;
import com.ab.sort.dto.CreateRecordDto;
import com.ab.sort.mapper.RecordMapper;
import com.ab.sort.model.Record;
import com.ab.sort.model.RecordItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
        record.setTotalAmount(amount);
        discount += record.getCouponDiscount();
        record.setTotalDiscount(discount);
        record.setBillingAmount(amount-discount);
        recordRepo.save(record);
        return record.toString();
    }

    @GetMapping("/getSales")
    public List<Record> getSales(){
        return recordRepo.findAllByType("sale");
    }

    @GetMapping("/getExpenses")
    public List<Record> getExpenses(){
        return recordRepo.findAllByType("expense");
    }
}

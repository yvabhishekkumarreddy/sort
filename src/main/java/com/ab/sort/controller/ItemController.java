package com.ab.sort.controller;

import com.ab.sort.dto.AddItemDto;
import com.ab.sort.model.ItemCategory;
import com.ab.sort.model.Measurement;
import com.ab.sort.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem")
    public String addItem(@RequestBody AddItemDto addItemDto){
        return itemService.save(addItemDto);
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestBody ItemCategory itemCategory){
        return itemService.addCategory(itemCategory);
    }

    @PostMapping("/addMeasurement")
    public String addMeasurement(@RequestBody Measurement measurement){
        return itemService.addMeasurement(measurement);
    }

    @GetMapping("/getItems")
    public List<AddItemDto> getItems(){
        return itemService.getItems();
    }
}

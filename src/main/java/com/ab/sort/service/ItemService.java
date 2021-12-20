package com.ab.sort.service;

import com.ab.sort.dao.CategoryRepo;
import com.ab.sort.dao.ItemRepo;
import com.ab.sort.dao.MeasurementRepo;
import com.ab.sort.dto.AddItemDto;
import com.ab.sort.mapper.ItemMapper;
import com.ab.sort.model.Item;
import com.ab.sort.model.ItemCategory;
import com.ab.sort.model.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private MeasurementRepo measurementRepo;
    @Autowired(required = false)
    private ItemMapper itemMapper;

    public String save(AddItemDto addItemDto){
        ItemCategory itemCategory = categoryRepo.findByCategory(addItemDto.getItemCategory());
        Measurement measurement = measurementRepo.findByMeasurementUnit(addItemDto.getMeasurement());
        if (measurement != null && itemCategory != null){
            Item item = itemMapper.mapDtoTo(addItemDto,itemCategory,measurement);
            itemRepo.save(item);
            return "Item added";
        }
        return "error";
    }

    public String addCategory(ItemCategory itemCategory) {
        categoryRepo.save(itemCategory);
        return itemCategory.getCategory()+" Category added";
    }

    public String addMeasurement(Measurement measurement) {
        measurementRepo.save(measurement);
        return measurement.getMeasurementUnit()+" added";
    }

    public List<AddItemDto> getItems() {
        List<Item> itemList = itemRepo.findAll();
        return itemMapper.mapToDtoList(itemList);
    }
}

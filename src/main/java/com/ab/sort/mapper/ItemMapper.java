package com.ab.sort.mapper;

import com.ab.sort.dto.AddItemDto;
import com.ab.sort.model.Item;
import com.ab.sort.model.ItemCategory;
import com.ab.sort.model.Measurement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "itemId",ignore = true)
    @Mapping(target = "itemCategory",source = "itemCategory")
    @Mapping(target = "measurement", source = "measurement")
    Item mapDtoTo(AddItemDto addItemDto, ItemCategory itemCategory, Measurement measurement);

//    @Mapping(target = "itemCategory",expression = "java(getItemCategory(item.itemCategory))")
//    @Mapping(target = "measurement",expression = "java(getMeasurement(item.measurement))")
    List<AddItemDto> mapToDtoList(List<Item> itemList);

    default String getItemCategory(ItemCategory itemCategory){
        return itemCategory.getCategory();
    }

    default String getMeasurement(Measurement measurement){
        return measurement.getMeasurementUnit();
    }
}

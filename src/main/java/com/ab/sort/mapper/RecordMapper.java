package com.ab.sort.mapper;

import com.ab.sort.dto.CreateRecordDto;
import com.ab.sort.model.Record;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecordMapper {

    Record mapDtoTo (CreateRecordDto createRecordDto);

}

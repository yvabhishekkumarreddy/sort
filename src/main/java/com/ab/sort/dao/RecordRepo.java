package com.ab.sort.dao;

import com.ab.sort.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepo extends JpaRepository<Record,Long> {

    List<Record> findAllByType(String type);
}

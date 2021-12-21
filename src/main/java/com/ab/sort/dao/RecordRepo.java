package com.ab.sort.dao;

import com.ab.sort.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepo extends JpaRepository<Record,Long> {
}

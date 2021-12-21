package com.ab.sort.dao;

import com.ab.sort.model.RecordItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordItemRepo extends JpaRepository<RecordItem,Long> {

}

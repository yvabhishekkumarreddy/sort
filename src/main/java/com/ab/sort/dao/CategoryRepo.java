package com.ab.sort.dao;

import com.ab.sort.model.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<ItemCategory,Integer> {

    ItemCategory findByCategory(String category);
}

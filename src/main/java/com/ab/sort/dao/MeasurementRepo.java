package com.ab.sort.dao;

import com.ab.sort.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepo extends JpaRepository<Measurement,Integer> {

    Measurement findByMeasurementUnit(String measurementUnit);
}

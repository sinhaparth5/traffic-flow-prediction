/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package io.github.TrafficFlowPrediction.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.TrafficFlowPrediction.entity.TrafficData;

/**
 *
 * @author parth
 */

 @Repository
public interface TrafficDataRepository extends JpaRepository<TrafficData, Long> {
    List<TrafficData> findByLocationAndTimestampBetween(
        String locationName, LocalDateTime startTime, LocalDateTime endTime);
        
    @Query("SELECT td FROM TrafficData td WHERE td.locationName = ?1 " + "AND td.timestamp >= ?2 ORDER BY td.timestamp DESC LIMIT 24")
    List<TrafficData> findLast24HoursData(String locationName, LocalDateTime starTime);
}

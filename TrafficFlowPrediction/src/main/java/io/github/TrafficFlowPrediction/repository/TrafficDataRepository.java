/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package io.github.TrafficFlowPrediction.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.TrafficFlowPrediction.entity.TrafficData;

/**
 *
 * @author parth
 */

 @Repository
public interface TrafficDataRepository extends JpaRepository<TrafficData, UUID> {
    // Basic finder methods
    List<TrafficData> findByLocationNameAndTimestampBetween(
        String locationName, 
        LocalDateTime startTime, 
        LocalDateTime endTime
    );
    
    // Pagination support
    Page<TrafficData> findByLocationName(String locationName, Pageable pageable);
    
    // Custom queries
    @Query("SELECT td FROM TrafficData td " +
           "WHERE td.locationName = :locationName " +
           "AND td.timestamp >= :startTime " +
           "ORDER BY td.timestamp DESC")
    List<TrafficData> findLast24HoursData(
        @Param("locationName") String locationName,
        @Param("startTime") LocalDateTime startTime
    );
    
    @Query("SELECT AVG(td.congestionLevel) FROM TrafficData td " +
           "WHERE td.locationName = :locationName " +
           "AND td.timestamp >= :startTime")
    Double findAverageCongestionLevel(
        @Param("locationName") String locationName,
        @Param("startTime") LocalDateTime startTime
    );
    
    @Query("SELECT COUNT(td) FROM TrafficData td " +
           "WHERE td.locationName = :locationName " +
           "AND td.timestamp >= :startTime " +
           "AND td.congestionLevel >= :level")
    Long countHighCongestionPeriods(
        @Param("locationName") String locationName,
        @Param("startTime") LocalDateTime startTime,
        @Param("level") Integer level
    );
}

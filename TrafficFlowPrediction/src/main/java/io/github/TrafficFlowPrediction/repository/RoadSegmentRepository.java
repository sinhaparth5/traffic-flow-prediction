/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package io.github.TrafficFlowPrediction.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.TrafficFlowPrediction.entity.RoadSegment;

/**
 *
 * @author parth
 */

 @Repository
public interface RoadSegmentRepository extends JpaRepository<RoadSegment, UUID> {
    List<RoadSegment> findByRoadType(String roadType);

    @Query(value = """
        SELECT * FROM road_segments rs 
        WHERE 
            (6371 * acos(
                cos(radians(:latitude)) * 
                cos(radians(rs.start_latitude)) * 
                cos(radians(rs.start_longitude) - radians(:longitude)) + 
                sin(radians(:latitude)) * 
                sin(radians(rs.start_latitude))
            ) <= :radiusKm
        OR 
            (6371 * acos(
                cos(radians(:latitude)) * 
                cos(radians(rs.end_latitude)) * 
                cos(radians(rs.end_longitude) - radians(:longitude)) + 
                sin(radians(:latitude)) * 
                sin(radians(rs.end_latitude))
            ) <= :radiusKm
        """, nativeQuery = true)
    List<RoadSegment> findNearbyRoadSegments(
        @Param("latitude") Double latitude,
        @Param("longitude") Double longitude,
        @Param("radiusKm") Double radiusKm
    );
}

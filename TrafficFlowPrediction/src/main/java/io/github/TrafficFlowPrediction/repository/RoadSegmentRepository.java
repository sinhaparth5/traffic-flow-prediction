/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package io.github.TrafficFlowPrediction.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.TrafficFlowPrediction.entity.RoadSegment;

/**
 *
 * @author parth
 */

 @Repository
public interface RoadSegmentRepository extends JpaRepository<RoadSegment, Long> {
    List<RoadSegment> findByRoadType(String roadType);

    @Query("SELECT rs FROM RoadSegment rs WHERE " +
           "ST_Distance(ST_MakePoint(rs.startLatitude, rs.startLongitude), " +
           "ST_MakePoint(?1, ?2)) <= ?3 OR " +
           "ST_Distance(ST_MakePoint(rs.endLatitude, rs.endLongitude), " +
           "ST_MakePoint(?1, ?2)) <= ?3")
    List<RoadSegment> findNearbyRoadSegments(Double latitude, Double longitude, Double radiusKm);
}

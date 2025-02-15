/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package io.github.TrafficFlowPrediction.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.TrafficFlowPrediction.entity.TrafficPrediction;

/**
 *
 * @author parth
 */

 @Repository
public interface TrafficPredictionRepository extends JpaRepository<TrafficPrediction, Long> {
    List<TrafficPrediction> findByLocationNameAndPredictionForTimestampAfter( String locationName, LocalDateTime timestamp);

    void deleteByPredictionForTimestampBefore(LocalDateTime timestamp);
}

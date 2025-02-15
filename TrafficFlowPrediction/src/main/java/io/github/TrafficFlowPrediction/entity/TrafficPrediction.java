/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.TrafficFlowPrediction.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author parth
 */

 @Entity
 @Table(name = "traffic_predictions")
 @Data
 @NoArgsConstructor
public class TrafficPrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "location_name", nullable = false)
    private String locationName;

    @Column(name = "predicted_vehicle_count")
    private Integer predictedVehicleCount;

    @Column(name = "predicted_congestion_level")
    private Integer predictedCongestionLevel;

    @Column(name = "prediction_timestamp", nullable = false)
    private LocalDateTime predictionTimestamp;

    @Column(name = "prediction_for_timestamp", nullable = false)
    private LocalDateTime predictionForTimestamp;

    @Column(name = "confidence_level")
    private Double confidenceLevel;
}

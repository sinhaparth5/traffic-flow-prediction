/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.TrafficFlowPrediction.dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 *
 * @author parth
 */

 @Data
public class TrafficPredictionDTO {
    private String locationName;
    private Integer predictedVehicleCount;
    private Integer predictedCongestionLevel;
    private LocalDateTime predictionForTimestamp;
    private Double confidenceLevel;
}

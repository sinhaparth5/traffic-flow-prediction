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
public class TrafficPredictionRequest {
    private String locationName;
    private LocalDateTime predictionTime;
    private Integer predictionHorizonHours;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.TrafficFlowPrediction.dto;

import lombok.Data;

/**
 *
 * @author parth
 */

 @Data
public class TrafficDataDTO {
    private String locationName;
    private Double latitude;
    private Double longitude;
    private Integer vehicleCount;
    private Integer averageSpeed;
    private Integer congestionLevel;
    private String weatherCondition;
}

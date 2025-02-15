/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.TrafficFlowPrediction.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author parth
 */

 @Data
public class TrafficDataDTO {
    @NotNull(message = "Location name is required")
    private String locationName;

    @NotNull(message = "Latitude is required")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    private Double longitude;

    @NotNull(message = "Vehicle count is required")
    @Min(value = 0, message = "Average speed must be > 0")
    private Integer vehicleCount;

    @NotNull(message = "Average speed is required")
    @Min(value = 0, message = "Average speed must be ≥ 0")
    private Double averageSpeed;

    @NotNull(message = "Congestion level is required")
    @Min(value = 0, message = "Congestion level must be ≥ 0")
    private Integer congestionLevel;

    @NotNull(message = "Weather condition is required")
    private String weatherCondition;
}

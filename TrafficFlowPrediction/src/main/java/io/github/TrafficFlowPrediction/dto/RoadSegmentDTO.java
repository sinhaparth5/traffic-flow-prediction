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
public class RoadSegmentDTO {
    private String name;
    private Double startLatitude;
    private Double startLongitude;
    private Double endLatitude;
    private Double endLongitude;
    private Double lengthKm;
    private Double roadType;
    private Integer speedLimit;
}

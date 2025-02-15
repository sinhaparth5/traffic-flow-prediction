/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.TrafficFlowPrediction.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.TrafficFlowPrediction.dto.TrafficDataDTO;
import io.github.TrafficFlowPrediction.dto.TrafficPredictionRequest;
import io.github.TrafficFlowPrediction.entity.RoadSegment;
import io.github.TrafficFlowPrediction.entity.TrafficData;
import io.github.TrafficFlowPrediction.entity.TrafficPrediction;
import io.github.TrafficFlowPrediction.repository.RoadSegmentRepository;
import io.github.TrafficFlowPrediction.repository.TrafficDataRepository;
import io.github.TrafficFlowPrediction.repository.TrafficPredictionRepository;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author parth
 */

 @Service
 @RequiredArgsConstructor
public class TrafficService {

    private final TrafficDataRepository trafficDataRepository;
    private final TrafficPredictionRepository predictionRepository;
    private final RoadSegmentRepository roadSegmentRepository;

    @Transactional
    public TrafficData recordDataRepository(TrafficDataDTO dto) {
        TrafficData data = new TrafficData();
        // Map DTO to entity
        data.setLocationName(dto.getLocationName());
        data.setLatitude(dto.getLatitude());
        data.setLongitude(dto.getLongitude());
        data.setVehicleCount(dto.getVehicleCount());
        data.setAverageSpeed(dto.getAverageSpeed());
        data.setCongestionLevel(dto.getCongestionLevel());
        data.setWeatherCondition(dto.getWeatherCondition());
        data.setTimestamp(LocalDateTime.now());

        return trafficDataRepository.save(data);
    }

    public List<TrafficData> getHistoricalData(String locationName, LocalDateTime startTime, LocalDateTime endTime) {
        return trafficDataRepository.findByLocationNameAndTimestampBetween(locationName, startTime, endTime);
    }

    @Transactional
    public TrafficPrediction predictTrafficFlow(TrafficPredictionRequest request) {
        // Get historical data
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime = now.minusHours(24); // Last 24 hours
        List<TrafficData> historicalData = trafficDataRepository.findLast24HoursData(request.getLocationName(), startTime);

        // Implement prediction logic here
        // This is a placeholder - you'll need to implement your ML model
        TrafficPrediction prediction = new TrafficPrediction();
        prediction.setLocationName(request.getLocationName());
        prediction.setPredictionTimestamp(now);
        prediction.setPredictionForTimestamp(request.getPredictionTime());
        // Set other predicted values
        
        return predictionRepository.save(prediction);
    }

    public List<RoadSegment> getNearbyRoadSegments(Double latitude, 
                                                  Double longitude, 
                                                  Double radiusKm) {
        return roadSegmentRepository.findNearbyRoadSegments(latitude, longitude, radiusKm);
    }
}

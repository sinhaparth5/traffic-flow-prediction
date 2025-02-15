/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.TrafficFlowPrediction.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.TrafficFlowPrediction.dto.TrafficDataDTO;
import io.github.TrafficFlowPrediction.dto.TrafficPredictionRequest;
import io.github.TrafficFlowPrediction.entity.TrafficData;
import io.github.TrafficFlowPrediction.entity.TrafficPrediction;
import io.github.TrafficFlowPrediction.service.TrafficService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

/**
 *
 * @author parth
 */

 @RestController
 @RequestMapping("/api/v1/traffic")
 @RequiredArgsConstructor
 @Tag(name = "Traffic Flow Controller", description = "APIs for traffic flow data and predictions")
public class TrafficController {

    private static final Logger log = Logger.getLogger(TrafficController.class.getName());

    private final TrafficService trafficService;

    @Operation(
        summary = "Record new traffic data",
        description = "Records a new traffic data point for a specific location"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Traffic data recorded successfully",
        content = @Content(schema = @Schema(implementation = TrafficData.class))
    )
    @PostMapping("/data")
    public ResponseEntity<TrafficData> recordTrafficData(
        @Valid @RequestBody TrafficDataDTO trafficDataDTO
    ) {
        log.info("Received TrafficDataDTO:" + trafficDataDTO);
        return ResponseEntity.ok(trafficService.recordDataRepository(trafficDataDTO));
    }

    @Operation(
        summary = "Get historical traffic data",
        description = "Retrieves historical traffic data for a specific location and time range"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Historical traffic data retrieved successfully",
        content = @Content(schema = @Schema(implementation = TrafficData.class))
    )
    @GetMapping("/historical")
    public ResponseEntity<List<TrafficData>> getHistoricalData(
        @Parameter(description = "Location name")
        @RequestParam String locationName,

        @Parameter(description = "Start time (yyyy-MM-dd'T'HH:mm:ss)")
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,

        @Parameter(description = "End time (yyyy-MM-dd'T'HH:mm:ss)")
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime
    ) {
        return ResponseEntity.ok(trafficService.getHistoricalData(locationName, startTime, endTime));
    }

    @Operation(
        summary = "Get traffic prediction",
        description = "Generates traffic prediction for a specific location and time"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Prediction generated successfully",
        content = @Content(schema = @Schema(implementation = TrafficPrediction.class))
    )
    @PostMapping("/predict")
    public ResponseEntity<TrafficPrediction> predictTrafficFlow(
            @Valid @RequestBody TrafficPredictionRequest request) {
        return ResponseEntity.ok(trafficService.predictTrafficFlow(request));
    }
}

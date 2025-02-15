/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.TrafficFlowPrediction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.TrafficFlowPrediction.entity.RoadSegment;
import io.github.TrafficFlowPrediction.service.TrafficService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author parth
 */

@RestController
@RequestMapping("/api/v1/roads")
@RequiredArgsConstructor
@Tag(name = "Road Segment Controller", description = "APIs for road segment management")
public class RoadSegmentController {
    private final TrafficService trafficService;

    @Operation(
        summary = "Get nearby road segments",
        description = "Finds road segments within a specified radius of a location"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Nearby road segments found",
        content = @Content(schema = @Schema(implementation = RoadSegment.class))
    )
    @GetMapping("/nearby")
    public ResponseEntity<List<RoadSegment>> getNearbyRoadSegments(
            @Parameter(description = "Latitude") 
            @RequestParam Double latitude,
            
            @Parameter(description = "Longitude") 
            @RequestParam Double longitude,
            
            @Parameter(description = "Radius in kilometers") 
            @RequestParam(defaultValue = "1.0") Double radiusKm) {
        return ResponseEntity.ok(trafficService.getNearbyRoadSegments(latitude, longitude, radiusKm));
    }
}

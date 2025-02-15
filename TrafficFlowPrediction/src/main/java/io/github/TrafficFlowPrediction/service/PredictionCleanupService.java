/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.TrafficFlowPrediction.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.TrafficFlowPrediction.repository.TrafficPredictionRepository;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author parth
 */

 @Service
 @RequiredArgsConstructor
public class PredictionCleanupService {
    private final TrafficPredictionRepository predictionRepository;

    @Transactional
    public void cleanupOldPredictons() {
        predictionRepository.deleteByPredictionForTimestampBefore(LocalDateTime.now().minusHours(24));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.TrafficFlowPrediction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.TrafficFlowPrediction.dto.HelloResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author parth
 */

 @RestController
 @RequestMapping("/api/v1")
 @RequiredArgsConstructor
 @Tag(name = "Hello", description = "Hello World API")
public class HelloController {

    @Operation(
        summary = "Hello World",
        description = "Returns a simple Hello World message"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Successful response"
    )
    @GetMapping("/hello")
    public HelloResponse getHello() {
        return new HelloResponse("Hello World!");
    }
}

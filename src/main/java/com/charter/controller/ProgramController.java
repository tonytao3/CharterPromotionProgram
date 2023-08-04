package com.charter.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.charter.service.PromotionReportService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/promote")
public class ProgramController {
	
	PromotionReportService promotionReportService;
	
	@Operation(
        operationId = "getPointsReport",
        summary = "Get Points Report.",
        tags = { "getPointsReport" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EntityResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EntityResponse.class))
            }),
            @ApiResponse(responseCode = "422", description = "Source Account NSF", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EntityResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EntityResponse.class))
            }),
            @ApiResponse(responseCode = "501", description = "Not Implemented", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EntityResponse.class))
            }),
            @ApiResponse(responseCode = "503", description = "Service Unavailable", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EntityResponse.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/points-report",
        produces = { "application/json" }
    )
    public ResponseEntity<List<Object>> getPointsReport(){
    	return promotionReportService.getPointsReport();
    }
}

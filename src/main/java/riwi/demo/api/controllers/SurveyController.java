package riwi.demo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import riwi.demo.api.dto.errors.BaseErrorResponse;

import riwi.demo.api.dto.request.SurveyReq;

import riwi.demo.api.dto.response.SurveyResp;

import riwi.demo.infrastructure.abstract_services.ISurveyService;

@RestController
@RequestMapping(path = "/surveys")
@AllArgsConstructor
public class SurveyController {
    
    @Autowired
    private final ISurveyService surveyService;

    @ApiResponse(responseCode = "400", description = "cuando el request no es valido", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BaseErrorResponse.class))
    })

    @Operation(summary = "Crea las surveys")

    @PostMapping
    public ResponseEntity<SurveyResp> insert(
            @Validated @RequestBody SurveyReq request) {
        return ResponseEntity.ok(this.surveyService.create(request));
    }

    @GetMapping
    
    public ResponseEntity<Page<SurveyResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size){
                return ResponseEntity.ok(this.surveyService.getAll(page - 1, size));
            }

}

package riwi.demo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import riwi.demo.api.dto.request.QuestionReq;

import riwi.demo.api.dto.response.QuestionResp;

import riwi.demo.infrastructure.abstract_services.IQuestionService;


@RestController
@RequestMapping(path = "/questions")
@AllArgsConstructor
public class QuestionController {
    
    @Autowired
    private final IQuestionService questionService;

    @Operation(summary = "obtiene toda la lista de preguntas de forma paginada")

    @GetMapping
    
    public ResponseEntity<Page<QuestionResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size){
                return ResponseEntity.ok(this.questionService.getAll(page - 1, size));
            }

    
    @ApiResponse(responseCode = "400", description = "cuando el request no es valido", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BaseErrorResponse.class))
    })

    @Operation(summary = "Crea las preguntas")

    @PostMapping
    public ResponseEntity<QuestionResp> insert(
            @Validated @RequestBody QuestionReq request) {
        return ResponseEntity.ok(this.questionService.create(request));
    }

    @Operation(summary = "Actualiza las preguntas")
        @ApiResponse(responseCode = "400", description = "cuando el request no es valido", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BaseErrorResponse.class))
})
        @PutMapping(path = "/{id}")
    public ResponseEntity<QuestionResp> update(
            @Validated @RequestBody QuestionReq request,
            @PathVariable String id) {
        return ResponseEntity.ok(this.questionService.update(request, id));
    }

    @Operation(summary = "Elimina preguntas")
        @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.questionService.delete(id);
        return ResponseEntity.noContent().build();
    }



}

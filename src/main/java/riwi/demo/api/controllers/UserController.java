package riwi.demo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import riwi.demo.api.dto.errors.ErrorResponse;
import riwi.demo.api.dto.request.UserReq;
import riwi.demo.api.dto.response.UserResp;
import riwi.demo.infrastructure.abstract_services.IUserService;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    
    @Autowired
    private final IUserService userService;

    @Operation(summary = "obtiene toda la lista de usuarios de forma paginada")

    @GetMapping
    public ResponseEntity<Page<UserResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size){
                return ResponseEntity.ok(this.userService.getAll(page - 1, size));
            }
    



    @ApiResponse(responseCode = "400", description = "cuando el request no es valido", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BaseErrorResponse.class))
    })

    @PostMapping
    public ResponseEntity<UserResp> insert(
            @Validated @RequestBody UserReq request) {
        return ResponseEntity.ok(this.userService.create(request));
    }

    @ApiResponse(responseCode = "400", description = "cuando el ID no es valido", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
})

        @GetMapping(path = "/{id}")
    public ResponseEntity<UserResp> get(
            @PathVariable String id) {
        return ResponseEntity.ok(this.userService.get(id));
    }



    @ApiResponse(responseCode = "400", description = "cuando el request no es valido", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BaseErrorResponse.class))
})
        @PutMapping(path = "/{id}")
    public ResponseEntity<UserResp> update(
            @Validated @RequestBody UserReq request,
            @PathVariable String id) {
        return ResponseEntity.ok(this.userService.update(request, id));
    }



    
}

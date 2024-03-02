package org.esg.exercise.rest;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.esg.exercise.dto.CustomerDto;
import org.esg.exercise.service.GetFromDatabase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping("/customers")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerAdaptorController {
    private GetFromDatabase getFromDatabase;

    @Operation(summary = "Save Customer Contact Detail to DB")
    /*@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account balance set to zero"),
            @ApiResponse(responseCode = "404", description = "Account not found", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)))})*/
    @PostMapping(value = "/contact/save", consumes = "application/json")
    public void postCustomerContactDetail(@RequestBody final String payload) {
        System.out.println("HERE!!" + payload);
    }

    @Operation(summary = "getCustomerContactDetail")
    /*@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account balance set to zero"),
            @ApiResponse(responseCode = "404", description = "Account not found", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)))})*/
    @GetMapping(value = "/{accountNumber}/contacts"/*, produces = APPLICATION_JSON_VALUE*/)
    public ResponseEntity<CustomerDto> getCustomerContactDetail(@PathVariable final String accountNumber) {
        System.out.println("HERE!!" + accountNumber);
        return ok(getFromDatabase.getCustomerData(accountNumber));
    }
}

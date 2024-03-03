package org.esg.exercise.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.esg.exercise.dto.CustomerDto;
import org.esg.exercise.service.GetFromDatabase;
import org.esg.exercise.service.SaveToDatabase;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RequestMapping("/customers")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerAdaptorController {
    private final GetFromDatabase getFromDatabase;
    private final SaveToDatabase saveToDatabase;

    /*@Operation(summary = "Save Customer Contact Detail to DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account balance set to zero"),
            @ApiResponse(responseCode = "404", description = "Account not found", content = @Content(mediaType =
            "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType =
            "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)))})*/
    @PostMapping(value = "/contact/save", consumes = "application/json")
    public void postCustomerContactDetail(@RequestBody final String payload) throws JsonProcessingException {
        log.info("Posting Customer Contact Detail. payload [{}]", payload);
        saveToDatabase.save(payload);
    }

    /*@Operation(summary = "getCustomerContactDetail")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account balance set to zero"),
            @ApiResponse(responseCode = "404", description = "Account not found", content = @Content(mediaType =
            "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType =
            "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)))})*/
    @GetMapping(value = "/{accountNumber}/contacts", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> getCustomerContactDetail(@PathVariable final long customerRef) {
        log.info("Getting Customer Contact Detail. customerRef [{}]", customerRef);
        try {
            return ok(getFromDatabase.getCustomerData(customerRef));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
    }
}

package org.smart.simon.edu.app.web;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.smart.simon.edu.app.model.PersonShortResponse;
import org.smart.simon.edu.app.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Person REST API operations")
@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {
private final PersonService personService;
    @Operation(
            summary = "Get all persons",
            responses = @ApiResponse(responseCode = "200", description = "Persons", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PersonShortResponse.class))))
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonShortResponse> persons() {
        return personService.findAll();
    }
}

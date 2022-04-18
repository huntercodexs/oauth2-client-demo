package com.huntercodexs.oauth2clientdemo.restcontroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}")
@CrossOrigin(origins = "*")
@Tag(name = "OAUTH2-CLIENT-DEMO")
@Slf4j
public class WelcomeController {

    @Operation(
            summary = "Sample Controller",
            description = "This is a sample controller to test a OAUTH2"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json")
            })
    })
    @GetMapping(path = "/welcome")
    @ResponseBody
    public ResponseEntity<?> welcome() {
        log.debug("Welcome to OAUTH2-CLIENT-DEMO RestController");
        return ResponseEntity.ok().body("Welcome to OAUTH2-CLIENT-DEMO");
    }

}

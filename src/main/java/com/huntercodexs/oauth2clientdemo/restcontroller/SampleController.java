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
public class SampleController {

    @Operation(
            summary = "Admin Sample Controller",
            description = "This is a sample controller to test a OAUTH2"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json")
            })
    })
    @GetMapping(path = "/admin")
    @ResponseBody
    public ResponseEntity<?> admin() {
        log.debug("Admin on OAUTH2-CLIENT-DEMO RestController");
        return ResponseEntity.ok().body("Admin on OAUTH2-CLIENT-DEMO");
    }

    @Operation(
            summary = "User Sample Controller",
            description = "This is a sample controller to test a OAUTH2"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json")
            })
    })
    @GetMapping(path = "/user")
    @ResponseBody
    public ResponseEntity<?> user() {
        log.debug("User on OAUTH2-CLIENT-DEMO RestController");
        return ResponseEntity.ok().body("User on OAUTH2-CLIENT-DEMO");
    }

    @Operation(
            summary = "Others Sample Controller",
            description = "This is a sample controller to test a OAUTH2"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json")
            })
    })
    @GetMapping(path = "/others")
    @ResponseBody
    public ResponseEntity<?> others() {
        log.debug("Others on OAUTH2-CLIENT-DEMO RestController");
        return ResponseEntity.ok().body("Others on OAUTH2-CLIENT-DEMO");
    }

}

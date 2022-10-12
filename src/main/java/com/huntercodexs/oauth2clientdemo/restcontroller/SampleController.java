package com.huntercodexs.oauth2clientdemo.restcontroller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}")
@CrossOrigin(origins = "*")
public class SampleController {

    @GetMapping(path = "/admin")
    @ResponseBody
    public ResponseEntity<?> admin() {
        return ResponseEntity.ok().body("Admin is running on OAUTH2-CLIENT-DEMO");
    }

    @GetMapping(path = "/user")
    @ResponseBody
    public ResponseEntity<?> user() {
        return ResponseEntity.ok().body("User is running on OAUTH2-CLIENT-DEMO");
    }

    @GetMapping(path = "/others")
    @ResponseBody
    public ResponseEntity<?> others() {
        return ResponseEntity.ok().body("Others is running on OAUTH2-CLIENT-DEMO");
    }

}

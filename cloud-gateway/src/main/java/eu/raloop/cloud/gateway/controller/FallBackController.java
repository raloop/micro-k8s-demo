package eu.raloop.cloud.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @GetMapping("/userServiceFallback")
    public ResponseEntity<String> userServiceFallBack() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("We are facing a problem. Please contact helpdesk");
    }

    @GetMapping("/userServiceFallBack")
    public ResponseEntity<String> userServiceFallbackMethod() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("User Service is taking longer than expected. " +
                        "Please try again later");
    }

    @GetMapping("/departmentServiceFallBack")
    public ResponseEntity<String> departmentServiceFallbackMethod() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Department Service is taking longer than expected. " +
                        "Please try again later");
    }
}

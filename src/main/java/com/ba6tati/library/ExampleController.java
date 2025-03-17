package com.ba6tati.library;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Example API", description = "Example endpoints for demonstration")
public class ExampleController {

    @GetMapping("/hello")
    @Operation(summary = "Get a greeting", description = "Returns a simple greeting message")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public String sayHello() {
        return "Hello, World!";
    }
}
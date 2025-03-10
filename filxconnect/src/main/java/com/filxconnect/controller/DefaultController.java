package com.filxconnect.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("FilxConnect Backend is Running!");
    }
}

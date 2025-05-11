package com.abc.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.abc.model.Heading;
import com.abc.abc.service.HeadingService;
import java.util.Collections;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from your frontend
public class HeadingController {

    @Autowired
    private HeadingService headingService;

    // Fetch the current heading
    @GetMapping("/headings")
    public ResponseEntity<?> getAllHeadings() {
        try {
            String heading = headingService.getAllHeadings();  // Fetch heading from the service
            return ResponseEntity.ok().body(Collections.singletonMap("heading", heading)); // Send as JSON
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "Error retrieving heading"));
        }
    }

    // Update or add a new heading
    @PostMapping("/heading")
    public ResponseEntity<?> addHeading(@RequestBody Heading heading) {
        try {
            String result = headingService.addHeading(heading.getHeading());  // Add the heading
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Collections.singletonMap("message", result));  // Return success or failure message as JSON
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "Error saving heading"));
        }
    }
}
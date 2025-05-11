package com.abc.abc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.abc.model.Heading;
import com.abc.abc.repository.HeadingRepository;

@Service
public class HeadingService {

    @Autowired
    private HeadingRepository headingRepository;

    // Get the single (latest) heading
    public String getAllHeadings() {
        Heading heading = headingRepository.findAll().stream().findFirst().orElse(null);
        return (heading != null) ? heading.getHeading() : "No heading found";
    }

    // Add or update the heading (only one record maintained)
    public String addHeading(String headingText) {
        Heading existingHeading = headingRepository.findAll().stream().findFirst().orElse(null);

        if (existingHeading != null) {
            existingHeading.setHeading(headingText);
            headingRepository.save(existingHeading);
            return "Heading updated successfully";
        } else {
            Heading newHeading = new Heading();
            newHeading.setHeading(headingText);
            headingRepository.save(newHeading);
            return "Heading added successfully";
        }
    }
}
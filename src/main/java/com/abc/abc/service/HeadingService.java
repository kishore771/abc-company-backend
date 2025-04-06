package com.abc.abc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.abc.model.Heading;
import com.abc.abc.repository.HeadingRepository;

@Service
public class HeadingService {

    @Autowired
    private HeadingRepository headingRepository;

   public String getAllHeadings() {
        StringBuilder headings = new StringBuilder();
        for (Heading heading : headingRepository.findAll()) {
            headings.append(heading.getHeading()).append("\n");
        }
        return headings.toString();
    }

    public String getHeadingById(int headingId) {
        Heading heading = headingRepository.findById(headingId).orElse(null);
        if (heading != null) {
            return heading.getHeading();
        } else {
            return "Heading not found";
        }
    }

    public String addHeading(String heading) {
        Heading newHeading = new Heading(0, heading); // Assuming ID is auto-generated
        headingRepository.save(newHeading);
        return "Heading added successfully";
    }
}
// Compare this snippet from src/main/java/com/abc/abc/AbcApplication.java:
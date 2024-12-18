package org.smart.simon.edu.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("/api/highload")
@RequiredArgsConstructor
public class UtilsController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String getFromResourceFile() throws IOException {
        String str = "";
        Resource resource = new ClassPathResource("sample.txt"); 
        try (FileInputStream inputStream = new FileInputStream(resource.getFile())) {
            str = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        }
        return str;
    }

}

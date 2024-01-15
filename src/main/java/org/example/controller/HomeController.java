package org.example.controller;

import org.example.dto.ExampleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<ExampleDto> home() {
        ExampleDto exampleDto=new ExampleDto();
        exampleDto.setId(1);
        exampleDto.setName("이한나");
        return ResponseEntity.ok().body(exampleDto);
    }
}

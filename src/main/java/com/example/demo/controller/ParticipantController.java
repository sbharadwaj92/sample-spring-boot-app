package com.example.demo.controller;

import com.example.demo.dto.ParticipantDto;
import com.example.demo.service.ParticipantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ParticipantController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ParticipantController.class);

    private ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping(value = "/participants", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ParticipantDto> post(@RequestBody ParticipantDto participantDto) {
        return ResponseEntity.ok(participantService.save(participantDto));
    }

    @GetMapping(value = "/participants/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ParticipantDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(participantService.get(id));
    }

    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ParticipantDto>> getAll() {
        return ResponseEntity.ok(participantService.getAll());
    }
}

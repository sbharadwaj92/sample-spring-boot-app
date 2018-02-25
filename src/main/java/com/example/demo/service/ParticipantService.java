package com.example.demo.service;

import com.example.demo.dto.ParticipantDto;

import java.util.List;

public interface ParticipantService {

    ParticipantDto save(ParticipantDto participantDto);

    ParticipantDto get(Long id);

    List<ParticipantDto> getAll();
}

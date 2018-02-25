package com.example.demo.service;

import com.example.demo.dao.ParticipantDao;
import com.example.demo.dto.ParticipantDto;
import com.example.demo.dto.transformer.ParticipantTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ParticipantServiceImpl.class);

    private ParticipantDao participantDao;
    private ParticipantTransformer participantTransformer;

    public ParticipantServiceImpl(ParticipantDao participantDao, ParticipantTransformer participantTransformer) {
        this.participantDao = participantDao;
        this.participantTransformer = participantTransformer;
    }

    @Override
    public ParticipantDto save(ParticipantDto participantDto) {
        return participantTransformer.fromDomainToDto(
                participantDao.save(participantTransformer.fromDtoToDomain(participantDto))
        );
    }

    @Override
    public ParticipantDto get(Long id) {
        return participantTransformer.fromDomainToDto(
                participantDao.findOne(id)
        );
    }

    @Override
    public List<ParticipantDto> getAll() {
        return participantTransformer.fromDomainToDto(
                participantDao.findAll()
        );
    }
}

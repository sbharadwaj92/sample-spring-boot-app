package com.example.demo.dto.transformer;

import com.example.demo.domain.Participant;
import com.example.demo.dto.ParticipantDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParticipantTransformer {

    private final static Logger LOGGER = LoggerFactory.getLogger(ParticipantTransformer.class);

    public Participant fromDtoToDomain(ParticipantDto participantDto) {
        Participant participant = new Participant();

        participant.setFirstName(participantDto.getFirstName());
        participant.setAge(participantDto.getAge());
        participant.setLastName(participantDto.getLastName());
        participant.setMobileNumber(participantDto.getMobileNumber());
        participant.setEmailAddress(participantDto.getEmailAddress());

        return participant;
    }

    public ParticipantDto fromDomainToDto(Participant participant) {

        if(participant == null) return null ;

        ParticipantDto participantDto = new ParticipantDto();

        participantDto.setFirstName(participant.getFirstName());
        participantDto.setAge(participant.getAge());
        participantDto.setLastName(participant.getLastName());
        participantDto.setMobileNumber(participant.getMobileNumber());
        participantDto.setId(participant.getId());
        participantDto.setEmailAddress(participant.getEmailAddress());

        return participantDto;
    }

    public List<ParticipantDto> fromDomainToDto(List<Participant> participantList) {
        return participantList.stream()
                .map(participant -> this.fromDomainToDto(participant))
                .collect(Collectors.toList());
    }
}

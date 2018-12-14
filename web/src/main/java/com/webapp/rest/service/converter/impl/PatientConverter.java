package com.webapp.rest.service.converter.impl;

import com.modelsale.model.Patient;
import com.modelsale.model.State;
import com.webapp.rest.model.PatientDto;
import com.webapp.rest.repository.StateRepository;
import com.webapp.rest.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PatientConverter implements Converter<Patient, PatientDto> {

    private final StateRepository stateRepository;

    @Autowired
    public PatientConverter(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public PatientDto convert(Patient entity) {
        PatientDto dto = new PatientDto();

        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setStateId(entity.getState().getId());

        return dto;
    }

    @Override
    public Patient convert(PatientDto dto) {
        State state = stateRepository.findById(dto.getStateId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find state with id = " + dto.getStateId()));

        Patient patient = new Patient();

        patient.setId(dto.getId());
        patient.setPhone(dto.getPhone());
        patient.setState(state);

        return patient;
    }
}

package com.webapp.rest.service.impl;

import com.modelsale.model.Patient;
import com.webapp.rest.model.PatientDto;
import com.webapp.rest.service.AbstractCrudService;
import com.webapp.rest.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PatientService extends AbstractCrudService<Patient, PatientDto> {

    @Autowired
    public PatientService(
            JpaRepository<Patient, Integer> repository,
            Converter<Patient, PatientDto> converter
    ) {
        super(repository, converter);
    }
}

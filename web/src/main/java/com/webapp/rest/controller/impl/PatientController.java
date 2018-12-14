package com.webapp.rest.controller.impl;

import com.modelsale.model.Patient;
import com.webapp.rest.controller.AbstractCrudController;
import com.webapp.rest.model.PatientDto;
import com.webapp.rest.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController extends AbstractCrudController<Patient, PatientDto> {

    @Autowired
    public PatientController(ICrudService<Patient, PatientDto> service) {
        super(service);
    }

}

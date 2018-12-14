package com.webapp.rest.service.converter.impl;

import com.modelsale.model.Patient;
import com.modelsale.model.Product;
import com.modelsale.model.Transaction;
import com.webapp.rest.model.TransactionDto;
import com.webapp.rest.repository.PatientRepository;
import com.webapp.rest.repository.ProductRepository;
import com.webapp.rest.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter implements Converter<Transaction, TransactionDto> {

    private final PatientRepository patientRepository;
    private final ProductRepository productRepository;

    @Autowired
    public TransactionConverter(
            PatientRepository patientRepository,
            ProductRepository productRepository
    ) {
        this.patientRepository = patientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public TransactionDto convert(Transaction entity) {
        TransactionDto dto = new TransactionDto();

        dto.setId(entity.getId());
        dto.setPatientId(entity.getPatient().getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setDate(entity.getDateTransaction());

        return dto;
    }

    @Override
    public Transaction convert(TransactionDto dto) {
        Patient patient = patientRepository
                .findById(dto.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find patient with id = " + dto.getPatientId()));

        Product product = productRepository
                .findById(dto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find product with id = " + dto.getProductId()));

        Transaction entity = new Transaction();

        entity.setId(dto.getId());
        entity.setDateTransaction(dto.getDate());

        entity.setPatient(patient);
        entity.setProduct(product);

        return entity;
    }
}

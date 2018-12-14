package com.webapp.rest.service.impl;

import com.modelsale.model.Transaction;
import com.webapp.rest.model.TransactionDto;
import com.webapp.rest.service.AbstractCrudService;
import com.webapp.rest.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class TransactionService extends AbstractCrudService<Transaction, TransactionDto> {

    @Autowired
    public TransactionService(
            JpaRepository<Transaction, Integer> repository,
            Converter<Transaction, TransactionDto> converter
    ) {
        super(repository, converter);
    }

    @Override
    public void save(TransactionDto dto) {
        Transaction entity = converter.convert(dto);

        Integer patStateId = entity.getPatient().getState().getId();
        Integer prdStateId = entity.getProduct().getState().getId();

        if (!Objects.equals(patStateId, prdStateId)) {
            throw new IllegalArgumentException("Patient and product state mismatch");
        }

        repository.save(entity);
    }
}

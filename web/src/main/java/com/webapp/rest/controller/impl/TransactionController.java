package com.webapp.rest.controller.impl;

import com.modelsale.model.Transaction;
import com.webapp.rest.controller.AbstractCrudController;
import com.webapp.rest.model.TransactionDto;
import com.webapp.rest.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transaction")
public class TransactionController extends AbstractCrudController<Transaction, TransactionDto> {

    @Autowired
    public TransactionController(ICrudService<Transaction, TransactionDto> service) {
        super(service);
    }
}

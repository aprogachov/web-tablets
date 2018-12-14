package com.tablet.menu.transaction;

import com.modelsale.model.Transaction;
import com.tablet.menu.IMenuItem;
import com.tablet.repository.IListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class SaleSearchAllMenuItem implements IMenuItem {

    private final IListRepository<Transaction> transactionRepository;

    @Autowired
    public SaleSearchAllMenuItem(IListRepository<Transaction> transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public String getTitle() {
        return "Print all sales";
    }

    @Override
    @Transactional
    public int doAction() {
        transactionRepository.findAll().forEach(System.out::println);
        return 0;
    }
}

package com.webapp.rest.service.impl;

import com.modelsale.model.Product;
import com.webapp.rest.model.ProductDto;
import com.webapp.rest.service.AbstractCrudService;
import com.webapp.rest.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductService extends AbstractCrudService<Product, ProductDto> {

    @Autowired
    public ProductService(
            JpaRepository<Product, Integer> repository,
            Converter<Product, ProductDto> converter
    ) {
        super(repository, converter);
    }
}

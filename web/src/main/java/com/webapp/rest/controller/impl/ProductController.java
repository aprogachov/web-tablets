package com.webapp.rest.controller.impl;

import com.modelsale.model.Product;
import com.webapp.rest.controller.AbstractCrudController;
import com.webapp.rest.model.ProductDto;
import com.webapp.rest.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractCrudController<Product, ProductDto> {

    @Autowired
    public ProductController(ICrudService<Product, ProductDto> service) {
        super(service);
    }

}

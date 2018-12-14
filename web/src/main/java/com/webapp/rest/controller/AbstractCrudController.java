package com.webapp.rest.controller;

import com.modelsale.model.IEntity;
import com.webapp.rest.model.IDto;
import com.webapp.rest.service.ICrudService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class AbstractCrudController<E extends IEntity, D extends IDto> {

    private final ICrudService<E, D> service;

    public AbstractCrudController(ICrudService<E, D> service) {
        this.service = service;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody D dto) {
        service.save(dto);
    }

    @RequestMapping("/{id}")
    public D find(@PathVariable("id") Integer id) {
        return service.find(id);
    }

    @RequestMapping("/list")
    public List<D> findAll() {
        return service.findAll();
    }
}

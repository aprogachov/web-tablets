package com.webapp.rest.service;

import com.modelsale.model.IEntity;
import com.webapp.rest.model.IDto;

import java.util.List;

public interface ICrudService<E extends IEntity, D extends IDto> {
    void save(D dto);

    D find(Integer id);

    List<D> findAll();
}

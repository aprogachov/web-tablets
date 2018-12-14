package com.webapp.rest.service.converter;

import com.modelsale.model.IEntity;
import com.webapp.rest.model.IDto;

public interface Converter<E extends IEntity, D extends IDto> {

    D convert(E entity);

    E convert(D dto);
}

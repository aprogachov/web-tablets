package com.webapp.rest.model;

import lombok.Data;

@Data
public class ProductDto implements IDto {

    private Integer id;
    private String name;
    private Integer stateId;

}

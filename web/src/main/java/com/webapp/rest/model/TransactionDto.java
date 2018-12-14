package com.webapp.rest.model;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDto implements IDto {
    private Integer id;
    private Integer patientId;
    private Integer productId;
    private Date date;
}

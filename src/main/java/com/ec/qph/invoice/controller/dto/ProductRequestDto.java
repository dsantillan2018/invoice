package com.ec.qph.invoice.controller.dto;

import lombok.Data;

/**
 * @author dsantillan
 */
@Data
public class ProductRequestDto {
    private long barCode;
    private long invoiceId;
    private String name;
    private float price;
    private String description;
}

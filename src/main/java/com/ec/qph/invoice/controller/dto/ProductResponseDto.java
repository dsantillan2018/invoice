package com.ec.qph.invoice.controller.dto;

import lombok.Data;

/**
 * @author dsantillan
 */
@Data
public class ProductResponseDto {
    private long productId;
    private long barCode;
    private String name;
    private float price;
    private String description;
}

package com.ec.qph.invoice.controller.dto;

import lombok.Data;

/**
 * @author dsantillan
 */
@Data
public class SupplierResponseDto {
    private long supplierId;
    private long ruc;
    private String name;
    private long phoneNumber;
    private String address;
}

package com.ec.qph.invoice.controller.dto;

import lombok.Data;

/**
 * @author dsantillan
 */
@Data
public class InvoiceResponseDto {
    private long invoiceId;
    private long invoiceNumber;
    private float totalPrice;
    private CustomerResponseDto customer;
    private SupplierResponseDto supplier;
}

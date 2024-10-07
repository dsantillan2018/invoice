package com.ec.qph.invoice.controller.dto;

import lombok.Data;

/**
 * @author dsantillan
 */
@Data
public class InvoiceRequestDto {
    private long invoiceNumber;
    private float totalPrice;
    private long supplierId;
    private long customerId;
    private CustomerRequestDto customer;
    private SupplierRequestDto supplier;
}

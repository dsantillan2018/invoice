package com.ec.qph.invoice.service;

import com.ec.qph.invoice.repository.entity.InvoiceEntity;

public interface InvoiceService {
    InvoiceEntity findById(long id);
    InvoiceEntity save(InvoiceEntity invoice);
    InvoiceEntity saveById(long id, long supplierId, long customerId, InvoiceEntity input);
    void deleteById(long id);
}

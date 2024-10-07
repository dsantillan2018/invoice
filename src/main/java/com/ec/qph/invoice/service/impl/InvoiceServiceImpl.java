package com.ec.qph.invoice.service.impl;

import com.ec.qph.invoice.controller.dto.InvoiceRequestDto;
import com.ec.qph.invoice.repository.CustomerRepository;
import com.ec.qph.invoice.repository.InvoiceRepository;
import com.ec.qph.invoice.repository.SupplierRepository;
import com.ec.qph.invoice.repository.entity.CustomerEntity;
import com.ec.qph.invoice.repository.entity.InvoiceEntity;
import com.ec.qph.invoice.repository.entity.SupplierEntity;
import com.ec.qph.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author dsantillan
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public InvoiceEntity findById(long id) {
        Optional<InvoiceEntity> invoice = invoiceRepository.findById(id);
        return invoice.orElse(null);
    }

    @Override
    public InvoiceEntity save(InvoiceEntity invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceEntity saveById(long id, long supplierId, long customerId, InvoiceEntity input) {
        Optional<InvoiceEntity>  invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            if (input.getInvoiceNumber() != 0) {
                invoice.get().setInvoiceNumber(input.getInvoiceNumber());
            }
            if (supplierId != 0) {
                Optional<SupplierEntity> optionalSupplier = supplierRepository.findById(supplierId);
                optionalSupplier.ifPresent(invoice.get()::setSupplier);
            }
            if (customerId != 0) {
                Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
                optionalCustomer.ifPresent(invoice.get()::setCustomer);
            }
            if (input.getTotalPrice() != 0) {
                invoice.get().setTotalPrice(input.getTotalPrice());
            }
            return invoiceRepository.save(invoice.get());
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(long id) {
        invoiceRepository.deleteById(id);
    }
}

package com.ec.qph.invoice.service;

import com.ec.qph.invoice.repository.InvoiceRepository;
import com.ec.qph.invoice.repository.entity.InvoiceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceServiceTest {

    @Autowired
    private InvoiceService invoiceService;

    @MockBean
    private InvoiceRepository invoiceRepository;

    @BeforeEach
    void setUp() {
        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setInvoiceId(1);
        invoice.setInvoiceNumber(455);
        invoice.setTotalPrice(45.56F);
        Mockito.when(invoiceRepository.findById(1L)).thenReturn(Optional.of(invoice));
    }

    @Test
    @DisplayName("Invoice valid information test")
    public void findByIdShouldFound() {
        long id = 1;
        InvoiceEntity invoice = invoiceService.findById(id);
        assertEquals(id, invoice.getInvoiceId());
        System.out.println("invoice = " + invoice);
    }
}
package com.ec.qph.invoice.controller;

import com.ec.qph.invoice.controller.dto.InvoiceRequestDto;
import com.ec.qph.invoice.controller.dto.InvoiceResponseDto;
import com.ec.qph.invoice.controller.mapper.InvoiceRequestMapper;
import com.ec.qph.invoice.controller.mapper.InvoiceResponseMapper;
import com.ec.qph.invoice.repository.entity.InvoiceEntity;
import com.ec.qph.invoice.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author dsantillan
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceRestController {

    @Autowired
    InvoiceRequestMapper invoiceRequestMapper;

    @Autowired
    InvoiceResponseMapper invoiceResponseMapper;

    @Autowired
    InvoiceServiceImpl invoiceServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponseDto> get(@PathVariable long id) {
        InvoiceEntity invoice = invoiceServiceImpl.findById(id);
        if (invoice != null) {
            return ResponseEntity.status(HttpStatus.OK).body(invoiceResponseMapper.InvoiceEntityToInvoiceResponseDto(invoice));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<InvoiceResponseDto> post(@RequestBody InvoiceRequestDto input) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(invoiceResponseMapper
                        .InvoiceEntityToInvoiceResponseDto(invoiceServiceImpl
                                .save(invoiceRequestMapper.InvoiceRequestDtoToInvoiceEntity(input))
                        )
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceResponseDto> put(@PathVariable(name = "id") long id, @RequestBody InvoiceRequestDto input) {
        InvoiceEntity invoice = invoiceServiceImpl.saveById(id, input.getSupplierId(), input.getCustomerId(), invoiceRequestMapper.InvoiceRequestDtoToInvoiceEntity(input));
        if (invoice != null) {
            return ResponseEntity.status(HttpStatus.OK).body(invoiceResponseMapper.InvoiceEntityToInvoiceResponseDto(invoice));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        invoiceServiceImpl.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

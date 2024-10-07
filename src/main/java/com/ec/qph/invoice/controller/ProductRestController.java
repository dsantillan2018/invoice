package com.ec.qph.invoice.controller;

import com.ec.qph.invoice.controller.dto.ProductRequestDto;
import com.ec.qph.invoice.controller.dto.ProductResponseDto;
import com.ec.qph.invoice.controller.mapper.ProductRequestMapper;
import com.ec.qph.invoice.controller.mapper.ProductResponseMapper;
import com.ec.qph.invoice.repository.entity.ProductEntity;
import com.ec.qph.invoice.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dsantillan
 */
@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @Autowired
    ProductRequestMapper productRequestMapper;

    @Autowired
    ProductResponseMapper productResponseMapper;

    @GetMapping()
    public List<ProductResponseDto> findByInvoiceId(@RequestParam(name = "invoiceId") long invoiceId) {
        return productResponseMapper.ProductEntityListToCustomerResponseDtolist(productServiceImpl.getProductsByInvoiceId(invoiceId));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> addProductToInvoice(@RequestBody ProductRequestDto input) {
        ProductEntity product = productServiceImpl.addProductToInvoice(productRequestMapper.ProductRequestDtoToProductEntity(input), input.getInvoiceId());
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseMapper.ProductEntityToProductResponseDto(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> put(@PathVariable(name = "id") long id, @RequestBody ProductRequestDto input) {
        ProductEntity product = productServiceImpl.saveById(productRequestMapper.ProductRequestDtoToProductEntity(input), id);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(productResponseMapper.ProductEntityToProductResponseDto(product));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{invoiceId}")
    public ResponseEntity<?> deleteByInvoiceId(@PathVariable(name = "invoiceId") long invoiceId) {
        productServiceImpl.deleteProductFromInvoice(invoiceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.ec.qph.invoice.service;

import com.ec.qph.invoice.repository.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getProductsByInvoiceId(long invoiceId);
    ProductEntity addProductToInvoice(ProductEntity product, long invoiceId);
    ProductEntity saveById(ProductEntity input, long id);
    void deleteProductFromInvoice(long invoiceId);
}

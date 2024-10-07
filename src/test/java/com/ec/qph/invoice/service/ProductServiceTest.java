package com.ec.qph.invoice.service;

import com.ec.qph.invoice.repository.InvoiceProductRepository;
import com.ec.qph.invoice.repository.entity.InvoiceProductEntity;
import com.ec.qph.invoice.repository.entity.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @MockBean
    InvoiceProductRepository invoiceProductRepository;

    @BeforeEach
    void setUp() {
        List<InvoiceProductEntity> invoiceProducts = new ArrayList<>();
        InvoiceProductEntity invoiceProduct = new InvoiceProductEntity();
        ProductEntity product = new ProductEntity();
        product.setProductId(1);
        product.setName("Table");
        product.setBarCode(22343);
        product.setDescription("Brown table");
        invoiceProduct.setInvoiceProductId(1);
        invoiceProduct.setInvoiceId(2);
        invoiceProduct.setProduct(product);
        invoiceProducts.add(invoiceProduct);
        Mockito.when(invoiceProductRepository.findByInvoiceId(2)).thenReturn(invoiceProducts);
    }

    @Test
    @DisplayName("Product valid invoice id test")
    public void findByInvoiceIdShouldFound() {
        long invoiceId = 2;
        List<ProductEntity> products = productService.getProductsByInvoiceId(invoiceId);
        assertEquals(products.getFirst().getName(), "Table");
        System.out.println("products = " + products);
    }
}
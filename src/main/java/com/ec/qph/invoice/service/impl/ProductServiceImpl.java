package com.ec.qph.invoice.service.impl;

import com.ec.qph.invoice.repository.InvoiceProductRepository;
import com.ec.qph.invoice.repository.ProductRepository;
import com.ec.qph.invoice.repository.entity.InvoiceProductEntity;
import com.ec.qph.invoice.repository.entity.ProductEntity;
import com.ec.qph.invoice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author dsantillan
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    InvoiceProductRepository invoiceProductRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductEntity> getProductsByInvoiceId(long invoiceId) {
        List<InvoiceProductEntity> invoiceProducts = invoiceProductRepository.findByInvoiceId(invoiceId);
        List<ProductEntity> products = new ArrayList<>();
        invoiceProducts.forEach( x -> {
            try {
                ProductEntity product = x.getProduct();
                products.add(product);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return products;
    }

    @Override
    public ProductEntity addProductToInvoice(ProductEntity product, long invoiceId) {
        InvoiceProductEntity invoice = new InvoiceProductEntity();
        invoice.setInvoiceId(invoiceId);
        invoice.setProduct(product);
        invoice = invoiceProductRepository.save(invoice);
        return invoice.getProduct();
    }

    @Override
    public ProductEntity saveById(ProductEntity input, long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductEntity newProduct = product.get();
            if (input.getBarCode() != 0) {
                newProduct.setBarCode(input.getBarCode());
            }
            if (input.getName() != null) {
                newProduct.setName(input.getName());
            }
            if (input.getPrice() != 0) {
                newProduct.setPrice(input.getPrice());
            }
            if (input.getDescription() != null) {
                newProduct.setDescription(input.getDescription());
            }
            return productRepository.save(newProduct);
        } else {
            return null;
        }
    }

    @Override
    public void deleteProductFromInvoice(long invoiceId) {
        List<InvoiceProductEntity> invoiceProducts = invoiceProductRepository.findByInvoiceId(invoiceId);
        invoiceProducts.forEach( x -> {
            invoiceProductRepository.deleteById(x.getInvoiceProductId());
        });
    }
}

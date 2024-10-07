package com.ec.qph.invoice.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 *
 * @author dsantillan
 */
@Entity
@Data
@Table(name = "qph_product", schema = "qph_practice_billing")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qph_product_seq_generator")
    @SequenceGenerator(name = "qph_product_seq_generator", sequenceName = "qph_product_seq", schema = "qph_practice_billing", allocationSize = 1)
    @Column(name = "product_id")
    private long productId;

    @Column(name = "bar_code")
    private long barCode;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceProductEntity> invoiceProducts;
}

package com.ec.qph.invoice.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author dsantillan
 */
@Entity
@Data
@Table(name = "qph_invoice_product", schema = "qph_practice_billing")
public class InvoiceProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qph_invoice_product_seq_generator")
    @SequenceGenerator(name = "qph_invoice_product_seq_generator", sequenceName = "qph_invoice_product_seq", schema = "qph_practice_billing", allocationSize = 1)
    @Column(name = "invoice_product_id")
    private long invoiceProductId;

    @Column(name = "invoice_id_qph_invoice")
    private long invoiceId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductEntity.class)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "product_id_qph_product", nullable = true)
    private ProductEntity product;
}

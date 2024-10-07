package com.ec.qph.invoice.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.List;

/**
 *
 * @author dsantillan
 */
@Entity
@Data
@Table(name = "qph_invoice", schema = "qph_practice_billing")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qph_invoice_seq_generator")
    @SequenceGenerator(name = "qph_invoice_seq_generator", sequenceName = "qph_invoice_seq", schema = "qph_practice_billing", allocationSize = 1)
    @Column(name = "invoice_id")
    private long invoiceId;

    @Column(name = "invoice_number")
    private long invoiceNumber;

    @Column(name = "total_price")
    private float totalPrice;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomerEntity.class)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "customer_id_qph_customer", nullable = true)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SupplierEntity.class)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "supplier_id_qph_supplier", nullable = true)
    private SupplierEntity supplier;

}

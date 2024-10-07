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
@Table(name = "qph_supplier", schema = "qph_practice_billing")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qph_supplier_seq_generator")
    @SequenceGenerator(name = "qph_supplier_seq_generator", sequenceName = "qph_supplier_seq", schema = "qph_practice_billing", allocationSize = 1)
    @Column(name = "supplier_id")
    private long supplierId;

    @Column(name = "ruc")
    private long ruc;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceEntity> invoices;
}

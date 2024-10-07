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
@Table(name = "qph_customer", schema = "qph_practice_billing")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qph_customer_seq_generator")
    @SequenceGenerator(name = "qph_customer_seq_generator", sequenceName = "qph_customer_seq", schema = "qph_practice_billing", allocationSize = 1)
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "identity_id")
    private long identityId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceEntity> invoices;

}

package com.ec.qph.invoice.repository;

import com.ec.qph.invoice.repository.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dsantillan
 */
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
}

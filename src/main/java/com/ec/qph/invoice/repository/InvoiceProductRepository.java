package com.ec.qph.invoice.repository;

import com.ec.qph.invoice.repository.entity.InvoiceProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author dsantillan
 */
public interface InvoiceProductRepository extends JpaRepository<InvoiceProductEntity, Long> {

    @Query("SELECT i FROM InvoiceProductEntity i WHERE i.invoiceId = ?1")
    public List<InvoiceProductEntity> findByInvoiceId(long invoiceId);

}

package com.ec.qph.invoice.repository;

import com.ec.qph.invoice.repository.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dsantillan
 */
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
}

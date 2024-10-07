package com.ec.qph.invoice.repository;

import com.ec.qph.invoice.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dsantillan
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}

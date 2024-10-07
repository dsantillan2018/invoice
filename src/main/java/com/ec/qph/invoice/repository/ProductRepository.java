package com.ec.qph.invoice.repository;

import com.ec.qph.invoice.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}

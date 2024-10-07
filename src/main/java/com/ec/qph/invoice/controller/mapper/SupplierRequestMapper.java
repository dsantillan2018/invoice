package com.ec.qph.invoice.controller.mapper;

import com.ec.qph.invoice.controller.dto.SupplierRequestDto;
import com.ec.qph.invoice.repository.entity.SupplierEntity;
import org.mapstruct.Mapper;

/**
 * @author dsantillan
 */
@Mapper(componentModel = "spring")
public interface SupplierRequestMapper {
    SupplierEntity SupplierRequestDtoToSupplierEntity(SupplierRequestDto source);
}

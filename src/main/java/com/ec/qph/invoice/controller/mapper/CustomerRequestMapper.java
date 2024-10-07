package com.ec.qph.invoice.controller.mapper;

import com.ec.qph.invoice.controller.dto.CustomerRequestDto;
import com.ec.qph.invoice.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

/**
 * @author dsantillan
 */
@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {
    CustomerEntity CustomerRequestDtoToCustomerEntity(CustomerRequestDto source);
}

package com.ec.qph.invoice.controller.mapper;

import com.ec.qph.invoice.controller.dto.CustomerResponseDto;
import com.ec.qph.invoice.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

/**
 * @author dsantillan
 */
@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {
    CustomerResponseDto CustomerEntityToCustomerResponseDto(CustomerEntity source);
}

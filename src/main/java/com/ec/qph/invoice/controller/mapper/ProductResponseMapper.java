package com.ec.qph.invoice.controller.mapper;

import com.ec.qph.invoice.controller.dto.ProductResponseDto;
import com.ec.qph.invoice.repository.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author dsantillan
 */
@Mapper(componentModel = "spring")
public interface ProductResponseMapper {
    ProductResponseDto ProductEntityToProductResponseDto(ProductEntity source);

    List<ProductResponseDto> ProductEntityListToCustomerResponseDtolist(List<ProductEntity> source);
}

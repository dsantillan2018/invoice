package com.ec.qph.invoice.controller.mapper;

import com.ec.qph.invoice.controller.dto.ProductRequestDto;
import com.ec.qph.invoice.repository.entity.ProductEntity;
import org.mapstruct.Mapper;

/**
 * @author dsantillan
 */
@Mapper(componentModel = "spring")
public interface ProductRequestMapper {
    ProductEntity ProductRequestDtoToProductEntity(ProductRequestDto source);
}

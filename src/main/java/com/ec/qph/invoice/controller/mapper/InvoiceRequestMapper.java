package com.ec.qph.invoice.controller.mapper;

import com.ec.qph.invoice.controller.dto.InvoiceRequestDto;
import com.ec.qph.invoice.repository.entity.InvoiceEntity;
import org.mapstruct.Mapper;

/**
 * @author dsantillan
 */
@Mapper(componentModel = "spring")
public interface InvoiceRequestMapper {
    InvoiceEntity InvoiceRequestDtoToInvoiceEntity(InvoiceRequestDto source);
}

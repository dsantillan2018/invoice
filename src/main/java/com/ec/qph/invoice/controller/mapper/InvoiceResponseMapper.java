package com.ec.qph.invoice.controller.mapper;

import com.ec.qph.invoice.controller.dto.InvoiceResponseDto;
import com.ec.qph.invoice.repository.entity.InvoiceEntity;
import org.mapstruct.Mapper;

/**
 * @author dsantillan
 */
@Mapper(componentModel = "spring")
public interface InvoiceResponseMapper {
    InvoiceResponseDto InvoiceEntityToInvoiceResponseDto(InvoiceEntity source);
}

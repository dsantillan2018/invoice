package com.ec.qph.invoice.controller.dto;

import lombok.Data;

/**
 * @author dsantillan
 */
@Data
public class CustomerResponseDto {
    private long customerId;
    private long identityId;
    private String name;
    private String lastName;
    private long phoneNumber;
    private String address;
}

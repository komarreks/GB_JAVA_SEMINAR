package ru.reks.ex1sem5.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private long senderAccountId;
    private long recivierAccountId;
    private BigDecimal amound;
}

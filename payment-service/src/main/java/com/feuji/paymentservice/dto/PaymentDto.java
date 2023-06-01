package com.feuji.paymentservice.dto;

import lombok.Data;

@Data
public class PaymentDto {
	private Integer paymentId;
	private String paymentStatus;
	private String transactionId;
	private int orderId;
	private double amount;

}

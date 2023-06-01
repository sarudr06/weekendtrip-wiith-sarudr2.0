package com.feuji.paymentservice.service;

import com.feuji.paymentservice.dto.PaymentDto;

public interface PaymentService {

	public String paymentProcessing();

	PaymentDto doPayment(PaymentDto paymentDto);

}

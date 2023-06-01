package com.feuji.paymentservice.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.feuji.paymentservice.model.Payment;

@Component
public class PaymentConverter {

	public PaymentDto convertEntityToDto(Payment payment) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(payment, PaymentDto.class);
	}

	public Payment convertDtoToEntity(PaymentDto paymentDto) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(paymentDto, Payment.class);
	}
}

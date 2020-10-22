package com.provigil.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.provigil.mapper.SubscriptionHelper;
import com.provigil.model.result.Subscription;

@Service
public class CalculatorService {

	public List<Subscription> sendResultxml(List<com.provigil.model.Subscription> input) {
		return input.stream().map(new SubscriptionHelper()).collect(Collectors.toList());
	}
}

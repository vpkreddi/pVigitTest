package com.provigil.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.provigil.mapper.SubscriptionHelper;
import com.provigil.model.result.Subscription;

@Service
@Validated
public class CalculatorService {
	
	@Autowired
	SubscriptionHelper helper;

	public List<Subscription> sendResultxml(List<com.provigil.model.Subscription> input) {
		return input.stream().map(helper).collect(Collectors.toList());
	}
}

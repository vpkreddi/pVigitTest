package com.provigil.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.provigil.model.Subscription;
import com.provigil.model.result.Result;
import com.provigil.service.CalculatorService;

@RestController("/")
@Validated
public class CalculatorController {

	@Autowired
	CalculatorService calService;

	@PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Result> calculateMonthlyCost(@RequestBody List<@Valid Subscription> subscriptions) {
		Result result = new Result();
		List<com.provigil.model.result.Subscription> output = calService.sendResultxml(subscriptions);
		result.setSubscription(output);
		return ResponseEntity.ok(result);
	}
}

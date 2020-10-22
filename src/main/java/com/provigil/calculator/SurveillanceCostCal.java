package com.provigil.calculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.provigil.model.Subscription;
import com.provigil.model.result.Result;
import com.provigil.service.CalculatorService;

@RestController
public class SurveillanceCostCal {

	@Autowired
	CalculatorService calService;

	@PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Result> calculateMonthlyCost(@RequestBody List<Subscription> subscriptions) {
		Result result = new Result();
		List<com.provigil.model.result.Subscription> output = calService.sendResultxml(subscriptions);
		result.setSubscription(output);
		return ResponseEntity.ok(result);
	}
}

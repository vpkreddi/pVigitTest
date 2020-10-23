package com.provigil.test.models;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.provigil.model.Subscription;

@JacksonXmlRootElement
public class InputXml {

	private Subscription subscription;

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	
}

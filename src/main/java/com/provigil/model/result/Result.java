package com.provigil.model.result;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JacksonXmlRootElement
public class Result {

	@JacksonXmlElementWrapper(useWrapping = false)
	List<Subscription> subscription;
}

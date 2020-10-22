package com.provigil.model.result;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subscription implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Double cost;
}

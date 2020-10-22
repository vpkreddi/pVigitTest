package com.provigil.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@JacksonXmlRootElement
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;
	@Positive
	private int id;
	@Positive
	private int area;
	private Plan plan;
	private Location location;
		
}




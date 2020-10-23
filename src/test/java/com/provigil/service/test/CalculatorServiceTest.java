package com.provigil.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.provigil.model.Subscription;
import com.provigil.service.CalculatorService;
import com.provigil.test.models.InputXml;

/**
 * Unit test for SurveillanceCostCal App.
 */
@SpringBootTest
public class CalculatorServiceTest {

	@Autowired
	CalculatorService calService;

	@Test
	@DisplayName("Outdoor Monthly area 4000 test")
	public void whenOutdoorMonthly4000ThenCost8500() throws FileNotFoundException, IOException {
		InputXml input = new InputXml();
		List<Subscription> inputList = new ArrayList<>(0);
		List<com.provigil.model.result.Subscription> output  = null;
		File file = new File("/home/vp/Downloads/surveillance-cost-cal/src/main/resources/OutdoorMonthly4000.xml");
		XmlMapper xmlMapper = new XmlMapper();
		String xml = inputStreamToString(new FileInputStream(file));
		input = xmlMapper.readValue(xml, InputXml.class);
		inputList.add(input.getSubscription());
		output = calService.sendResultxml(inputList);
		assertEquals(8500.00, output.get(0).getCost());
	}
	
	@Test
	@DisplayName("Outdoor Yearly area 4000 test")
	public void whenOutdoorYearly4000ThenCost6500() throws FileNotFoundException, IOException {
		InputXml input = new InputXml();
		List<Subscription> inputList = new ArrayList<>(0);
		List<com.provigil.model.result.Subscription> output  = null;
		File file = new File("/home/vp/Downloads/surveillance-cost-cal/src/main/resources/OutdoorYearly4000.xml");
		XmlMapper xmlMapper = new XmlMapper();
		String xml = inputStreamToString(new FileInputStream(file));
		input = xmlMapper.readValue(xml, InputXml.class);
		inputList.add(input.getSubscription());
		output = calService.sendResultxml(inputList);
		assertEquals(6500.00, output.get(0).getCost());
	}
	
	@Test
	@DisplayName("Indoor Monthly area 2500 test")
	public void whenIndoorMonthly2500ThenCost5000() throws FileNotFoundException, IOException {
		InputXml input = new InputXml();
		List<Subscription> inputList = new ArrayList<>(0);
		List<com.provigil.model.result.Subscription> output  = null;
		File file = new File("/home/vp/Downloads/surveillance-cost-cal/src/main/resources/IndoorMonthly2500.xml");
		XmlMapper xmlMapper = new XmlMapper();
		String xml = inputStreamToString(new FileInputStream(file));
		input = xmlMapper.readValue(xml, InputXml.class);
		inputList.add(input.getSubscription());
		output = calService.sendResultxml(inputList);
		assertEquals(5000.00, output.get(0).getCost());
	}
	
	
	@Test
	@DisplayName("Indoor Yearly area 2500 test")
	public void whenIndoorYearly2500ThenCost3750() throws FileNotFoundException, IOException {
		InputXml input = new InputXml();
		List<Subscription> inputList = new ArrayList<>(0);
		List<com.provigil.model.result.Subscription> output  = null;
		File file = new File("/home/vp/Downloads/surveillance-cost-cal/src/main/resources/IndoorYearly2500.xml");
		XmlMapper xmlMapper = new XmlMapper();
		String xml = inputStreamToString(new FileInputStream(file));
		input = xmlMapper.readValue(xml, InputXml.class);
		inputList.add(input.getSubscription());
		output = calService.sendResultxml(inputList);
		assertEquals(3750.00, output.get(0).getCost());
	}

	@Test
	@DisplayName("Indoor Monthly area 25000 test")
	public void whenIndoorMonthly25000ThenCost28750() throws FileNotFoundException, IOException {
		InputXml input = new InputXml();
		List<Subscription> inputList = new ArrayList<>(0);
		List<com.provigil.model.result.Subscription> output  = null;
		File file = new File("/home/vp/Downloads/surveillance-cost-cal/src/main/resources/IndoorMonthly25000.xml");
		XmlMapper xmlMapper = new XmlMapper();
		String xml = inputStreamToString(new FileInputStream(file));
		input = xmlMapper.readValue(xml, InputXml.class);
		inputList.add(input.getSubscription());
		output = calService.sendResultxml(inputList);
		assertEquals(28750.00, output.get(0).getCost());
	}
	
	@Test
	@DisplayName("Indoor Yearly area 25000 test")
	public void whenIndoorYearly25000ThenCost18250() throws FileNotFoundException, IOException {
		InputXml input = new InputXml();
		List<Subscription> inputList = new ArrayList<>(0);
		List<com.provigil.model.result.Subscription> output  = null;
		File file = new File("/home/vp/Downloads/surveillance-cost-cal/src/main/resources/IndoorYearly25000.xml");
		XmlMapper xmlMapper = new XmlMapper();
		String xml = inputStreamToString(new FileInputStream(file));
		input = xmlMapper.readValue(xml, InputXml.class);
		inputList.add(input.getSubscription());
		output = calService.sendResultxml(inputList);
		assertEquals(18250.00, output.get(0).getCost());
	}
	public String inputStreamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}
}

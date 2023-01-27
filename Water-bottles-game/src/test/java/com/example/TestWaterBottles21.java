package com.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("21 Water Bottle Assignment")
public class TestWaterBottles21 {
	
	private ByteArrayInputStream inputStream = null;
	private ByteArrayOutputStream byteArrayOutputStream = null;
	private WaterBottles21 bb;
	
	@BeforeEach
	public void doInit() {
		/*
		inputStream = new ByteArrayInputStream("-6".getBytes());
	    byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    fact = new Factorial(inputStream, ps);
	    */
	}
	
	@Test
	@DisplayName("Check whether input is valid for -ve")
	public void testIsInputValidForNegative() {
		 
	    inputStream = new ByteArrayInputStream("-5".getBytes());
	    byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    bb = new WaterBottles21(inputStream, ps);
		
		//testGetTheInputNumber();
	    int n = bb.isInputNumberValid();
	    String outputText = byteArrayOutputStream.toString();
	    String key = "As per the Game Rules, please pick up bottles between 1 and 4 only, both inclusive";
	    String output = outputText.substring(outputText.indexOf(key));
	    //Assertions.assertEquals("720",output);
	    Assertions.assertEquals("As per the Game Rules, please pick up bottles between 1 and 4 only, both inclusive",output);
	    Assertions.assertEquals(-1,n);
		
	}
	
	@Test
	@DisplayName("Check whether input is valid for any number outside 1,2,3,4")
	public void testIsInputValidForOutsideRange() {
		 
		inputStream = new ByteArrayInputStream("5".getBytes());
	    byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    bb = new WaterBottles21(inputStream, ps);
		
		//testGetTheInputNumber();
	    int n = bb.isInputNumberValid();
	    String outputText = byteArrayOutputStream.toString();
	    String key = "As per the Game Rules, please pick up bottles between 1 and 4 only, both inclusive";
	    String output = outputText.substring(outputText.indexOf(key));
	    //Assertions.assertEquals("720",output);
	    Assertions.assertEquals("As per the Game Rules, please pick up bottles between 1 and 4 only, both inclusive",output);
	    Assertions.assertEquals(-1,n);
		
	}
	
	@Test
	@DisplayName("Check whether input is valid for any number outside 1,2,3,4")
	public void testIsInputValidForString() {
		 
		inputStream = new ByteArrayInputStream("abc".getBytes());
	    byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    bb = new WaterBottles21(inputStream, ps);
		
		//testGetTheInputNumber();
	    int n = bb.isInputNumberValid();
	    String outputText = byteArrayOutputStream.toString();
	    String key = "As per the Game Rules, please pick up bottles between 1 and 4 only, both inclusive";
	    String output = outputText.substring(outputText.indexOf(key));
	    //Assertions.assertEquals("720",output);
	    Assertions.assertEquals("As per the Game Rules, please pick up bottles between 1 and 4 only, both inclusive",output);
	    Assertions.assertEquals(-1,n);
		
	}
	
	@Test
	@DisplayName("Check the logic how many computer picks up after user has picked 3")
	public void testPickAfterUserPicks3() {
		int userPick = 3; 
		inputStream = new ByteArrayInputStream(Integer.toString(userPick).getBytes());
	    byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    bb = new WaterBottles21(inputStream, ps);
			
	    int computerPick = bb.pickAfterUser(userPick);
	   
	    Assertions.assertEquals((5-userPick),computerPick);
		
	}
	
	@Test
	@DisplayName("Check the logic how many computer picks up after user has picked 4")
	public void testPickAfterUserPicks4() {
		int userPick = 4; 
		inputStream = new ByteArrayInputStream(Integer.toString(userPick).getBytes());
	    byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    bb = new WaterBottles21(inputStream, ps);
			
	    int n = bb.pickAfterUser(userPick);
	   
	    Assertions.assertEquals((5-userPick),n);
		
	}
	
	
	@Test
	@DisplayName("Print the Rules of Game")
	public void testprintGameRules() {
		 
		inputStream = new ByteArrayInputStream("1".getBytes());
	    byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    bb = new WaterBottles21(inputStream, ps);	
		//testGetTheInputNumber();
	    bb.printGameRules();
	    String outputText = byteArrayOutputStream.toString();
	    String key = """
	    		There are 21 Water bottles
	    		Computer and yourself, there are 2 players
	    		At a time, each one can pick up any no. of bottles between 1 and 4 (inclusive)
	    		The one who will have to pick up the last is looser
	    		Please play first
	    		""";
	    //String output = outputText.substring(outputText.indexOf(key));
	    //Assertions.assertEquals("720",output);
	    
	    Assertions.assertEquals(key.trim(),outputText.trim());
		
	}
	
	
	@AfterEach
	public void doTearDown() {
		inputStream = null;
		byteArrayOutputStream = null;
	
	}

}

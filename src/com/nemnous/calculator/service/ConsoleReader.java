package com.nemnous.calculator.service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nemnous.calculator.exceptions.InvalidArgumentsException;
import com.nemnous.calculator.interfaces.InputReader;
import com.nemnous.calculator.model.DoubleCalculator;
import com.nemnous.calculator.model.FloatCalculator;
import com.nemnous.calculator.model.IntegerCalculator;
import com.nemnous.calculator.model.Parameter;

public class ConsoleReader implements InputReader{
	private final Logger logger =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private Scanner scan = new Scanner(System.in);
	private InputParser inputParser = new InputParser();
	private static final String OUTPUT_FORMAT = "Output: {0}";
	private static final String INFO_MESSAGE = "\"Perform operations in the format\"\r\n" + 
			" " + "a + b, a - b, a * b, a / b enter 'h' for history and 'end' to exit\"";
	private ArrayList<String> history = new ArrayList<>();
	
	public void integerOperations() {
		IntegerCalculator integerCalculator = new IntegerCalculator();
		String equation = "";
		int output;
		logger.log(Level.INFO, INFO_MESSAGE);
		do {
			equation = scan.nextLine();
			Parameter param = inputParser.parseInput(equation);
			try {
				switch(param.getOperator()) {
					case "+":
						output = integerCalculator.add(param);
						logger.log(Level.INFO, OUTPUT_FORMAT, output);
						history.add(param.toString() + " : " + output);
						continue;
					case "-":
						output = integerCalculator.subtract(param);
						logger.log(Level.INFO, OUTPUT_FORMAT, output);
						history.add(param.toString() + " : " + output);
						continue;
					case "*":
						output = integerCalculator.multiply(param);
						logger.log(Level.INFO, OUTPUT_FORMAT, output);
						history.add(param.toString() + " : " + output);
						continue;
					case "/":
						output = integerCalculator.divide(param);
						logger.log(Level.INFO, OUTPUT_FORMAT, output);
						history.add(param.toString() + " : " + output);
						continue;
					default:
						if(equation.equalsIgnoreCase("h"))
							showHistory();
				}	
		} catch (InvalidArgumentsException | ArithmeticException e) {
			logger.log(Level.WARNING, e.getMessage());
			history.add(param.toString() + " : " + e.getMessage());
		}
			
	} while(!equation.equals("end"));
	}
	
	public void floatOperations() {
		FloatCalculator floatCalculator = new FloatCalculator();
		String equation = "";
		float output;
		do {
			equation = scan.nextLine();
			Parameter param = inputParser.parseInput(equation);
			logger.log(Level.INFO, INFO_MESSAGE);
			try {
				switch(param.getOperator()) {
					case "+":
						output = floatCalculator.add(param);
						logger.log(Level.INFO, OUTPUT_FORMAT, output);
						history.add(param.toString() + " : " + output);
						continue;
					case "-":
							output = floatCalculator.subtract(param);
							logger.log(Level.INFO, OUTPUT_FORMAT, output);
							history.add(param.toString() + " : " + output);
						continue;
					case "*":
							output = floatCalculator.multiply(param);
							logger.log(Level.INFO, OUTPUT_FORMAT, output);
							history.add(param.toString() + " : " + output);
						continue;
					case "/":
							output = floatCalculator.divide(param);
							logger.log(Level.INFO, OUTPUT_FORMAT, output);
							history.add(param.toString() + " : " + output);
						continue;
					default:
						if(equation.equalsIgnoreCase("h"))
							showHistory();
						continue;
			}
			} catch (InvalidArgumentsException e) {
				logger.log(Level.WARNING, e.getMessage());
				history.add(param.toString() + " : " + e.getMessage());
			}
			
		} while(!equation.equals("end"));
	}
	
	public void doubleOperations() {
		DoubleCalculator doubleCalculator = new DoubleCalculator();
		String equation = "";
		double output;
		do {
			equation = scan.nextLine();
			Parameter param = inputParser.parseInput(equation);
			logger.log(Level.INFO, INFO_MESSAGE);
			try {
				switch(param.getOperator()) {
					case "+":
						output = doubleCalculator.add(param);
						logger.log(Level.INFO, OUTPUT_FORMAT, output);
						history.add(param.toString() + " : " + output);
						continue;
					case "-":
							output = doubleCalculator.subtract(param);
							logger.log(Level.INFO, OUTPUT_FORMAT, output);
							history.add(param.toString() + " : " + output);
						continue;
					case "*":
							output = doubleCalculator.multiply(param);
							logger.log(Level.INFO, OUTPUT_FORMAT, output);
							history.add(param.toString() + " : " + output);
						continue;
					case "/":
							output = doubleCalculator.divide(param);
							logger.log(Level.INFO, OUTPUT_FORMAT, output);
							history.add(param.toString() + " : " + output);
						continue;
					default:
						if(equation.equalsIgnoreCase("h"))
							showHistory();
						continue;
			}
			} catch (InvalidArgumentsException e) {
				logger.log(Level.WARNING, e.getMessage());
				history.add(param.toString() + " : " + e.getMessage());
			}
			
		} while(!equation.equals("end"));
	}
	
	
	public void showHistory() {
		for(String i : history) {
			logger.log(Level.INFO, i);
		}
	}
	
	@Override
	public void read() {
		int choice = 0;
		do {
			logger.log(Level.INFO, "Choose a data type to perform Operations");
			logger.log(Level.INFO, "1. Integer\n2. Float3. Double");
			String option = scan.nextLine();
			if(!option.equals("") && option.matches("\\d+") && option.length() == 1) {
				choice = Integer.parseInt(option);
			} else {
				logger.log(Level.INFO, "Enter a valid number");
				continue;
			}
			switch (choice) {
				case 1:
					integerOperations();
					continue;
				case 2:
					floatOperations();
					continue;
				case 3:
					doubleOperations();
					continue;
				default:
					logger.log(Level.INFO, "Enter Valid Option");
			}
		} while(true);
	}
}


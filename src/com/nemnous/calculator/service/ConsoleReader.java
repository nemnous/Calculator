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

/**
 * This class implements InputReader.
 * All the input is driven from the console and
 * operations are performed.
 * @author nemnous.
 *
 */
public class ConsoleReader implements InputReader {
	private final Logger logger =
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private Scanner scan = new Scanner(System.in);
	private InputParser inputParser = new InputParser();
	private static final String OUTPUT_FORMAT = "Output: {0}";
	private static final String INFO_MESSAGE = "\"Perform operations in the format\"\r\n" + 
			" " + "a + b, a - b, a * b, a / b. Try 2 + 4. enter 'h' for history and 'end' to exit\"";
	private ArrayList<String> history = new ArrayList<>();

	/**
	 * All the integer operations are handled here.
	 */
	public void integerOperations() {
		IntegerCalculator integerCalculator = new IntegerCalculator();
		String equation = "";
		int output;
		logger.log(Level.INFO, INFO_MESSAGE);
		do {
			equation = scan.nextLine();
			Parameter param = null;
			try {
				param = inputParser.parseInput(equation);
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
				case "h":
					showHistory();
					continue;
				default:
					continue;
				}
			} catch (InvalidArgumentsException | ArithmeticException exception) {
				logger.log(Level.WARNING, exception.getMessage());
				String logOutput;
				if(param != null)
					logOutput = param.toString();
				else
					logOutput = "InvalidInput";
				history.add(logOutput + " : " + exception.getMessage());
			}
		} while(!equation.equals("end"));
	}

	/**
	 * All the float operations are done here.
	 */
	public void floatOperations() {
		logger.log(Level.INFO, INFO_MESSAGE);
		FloatCalculator floatCalculator = new FloatCalculator();
		String equation = "";
		float output;
		do {
			equation = scan.nextLine();
			Parameter param = null;
			try {
				param = inputParser.parseInput(equation);
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
				case "h":
					showHistory();
					continue;
				default:
					continue;
				}
			} catch (InvalidArgumentsException exception) {
				logger.log(Level.WARNING, exception.getMessage());
				String logOutput;
				if(param != null)
					logOutput = param.toString();
				else
					logOutput = "Invalid Input";
				history.add(logOutput + " : " + exception.getMessage());
			}

		} while(!equation.equals("end"));
	}

	/**
	 * All the double operations are done here.
	 */
	public void doubleOperations() {
		DoubleCalculator doubleCalculator = new DoubleCalculator();
		logger.log(Level.INFO, INFO_MESSAGE);
		String equation = "";
		double output;
		do {
			equation = scan.nextLine();
			Parameter param = null;
			try {
				param = inputParser.parseInput(equation);
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
				case "h":
					showHistory();
					continue;
				default:
					continue;
				}
			} catch (InvalidArgumentsException exception) {
				logger.log(Level.WARNING, exception.getMessage());
				String logOutput;
				if(param != null)
					logOutput = param.toString();
				else
					logOutput = "Invalid Input";
				history.add(logOutput + " : " + exception.getMessage());
			}

		} while(!equation.equals("end"));
	}

	/**
	 * Session history is showed
	 */
	public void showHistory() {
		for(String eachEntry : history) {
			logger.log(Level.INFO, eachEntry);
		}
	}

	/**
	 * Flow starts here. The data type for the
	 * operations is selected here and the control is transfered
	 * to respective functions.
	 */
	@Override
	public void read() {
		int choice = 0;
		do {
			logger.log(Level.INFO, "\n\nChoose a data type to perform Operations");
			logger.log(Level.INFO, "\n\n1. Integer\n\n2. Float\n\n3. Double");
			String option = scan.nextLine();
			if (option.equalsIgnoreCase("h")) {
				showHistory();
				continue;
			}
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


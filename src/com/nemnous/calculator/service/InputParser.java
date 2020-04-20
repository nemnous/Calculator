package com.nemnous.calculator.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.nemnous.calculator.exceptions.InvalidArgumentsException;
import com.nemnous.calculator.model.Parameter;

/**
 * This class parses the user Equation
 * and returns a Parameter object with the
 * values of operands and operator set.
 * @author nemnous
 *
 */
public class InputParser {
	private final Logger logger =
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String MESSAGE = "Invalid Operands"; 

	/**
	 * parses the equation for addition.
	 * @param equation
	 * @return parameter object with the value of operators and
	 * operator set to '+'.
	 */
	public Parameter parseAddition(String equation) {
		String[] input= equation.split("\\+");
		String paramA;
		String paramB;
		if(equation.trim().charAt(0) == '+' && input.length == 3) {
			paramA = input[1].trim();
			paramB = input[2].trim();

		} else {
			input = equation.split("\\+");
			paramA = input[0].trim();
			paramB = input[1].trim();
		}
		if(paramA.equals("") || input.length<2) {
			logger.log(Level.WARNING, MESSAGE);
			return new Parameter("", "", "");
		}
		return new Parameter(paramA , paramB, "+");
	}

	/**
	 * parses the equation for substraction.
	 * 
	 * @param equation
	 * @return Parameter object with operands set
	 *  to respective values and operator set to '-'.
	 */
	public Parameter parseSubtraction(String equation) {
		String[] input= equation.split("-");
		String paramA;
		String paramB;
		if(equation.trim().charAt(0) == '-' && input.length == 3) {
			paramA = "-" + input[1].trim();
			paramB = input[2];

		} else {
			input = equation.split("-");
			paramA = input[0].trim();
			paramB = input[1].trim();
		}
		if(paramA.equals("") || input.length<2) {
			logger.log(Level.WARNING, MESSAGE);
			return new Parameter("", "", "");
		}
		return new Parameter(paramA , paramB, "-");
	}

	/**
	 * Parses equation for multiplication.
	 * @param equation
	 * @return parameter object with operands set to input values
	 * and operator set to *
	 * 
	 */
	public Parameter parseMultiplication(String equation) {
		String[] input = equation.split("\\*");
		if(input[0].trim().equals("") || input.length<2) {
			logger.log(Level.WARNING, MESSAGE);
			return new Parameter("", "", "");
		}
		return new Parameter(input[0].trim() , input[1].trim(), "*");
	}
	
	/**
	 * parses equation for division.
	 * @param equation
	 * @return parameter object with operands set to
	 * input values and operator set to /.
	 */
	public Parameter parseDivison(String equation) {
		String[] input = equation.split("/");
		if(input[0].trim().equals("") || input.length<2) {
			logger.log(Level.WARNING, MESSAGE);
			return new Parameter("", "", "");
		}
		return new Parameter(input[0].trim() , input[1].trim(), "/");
	}
	
	/**
	 * This handles the raw equation and
	 * directs to respective functions for parsing.
	 * @param equation
	 * @return Parameter object with respective operands
	 * and operator from the equation.
	 */
	public Parameter parseInput(String equation) {
		if(equation.contains("*")) {
			return parseMultiplication(equation);
		} else if(equation.contains("/")) {
			return parseDivison(equation);
		} else if(equation.contains("+")) {
			return parseAddition(equation);
		}else if(equation.contains("-")) {
			return parseSubtraction(equation);
		}else if(equation.equalsIgnoreCase("h")) {
			return new Parameter("", "", "h");
		}
		throw new InvalidArgumentsException("Arguments can't be Empty.");
	}
}

package com.nemnous.calculator.service;

import java.util.logging.Level;
import java.util.logging.Logger;


import com.nemnous.calculator.model.Parameter;

public class InputParser {
	private final Logger logger =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String MESSAGE = "Invalid Operands"; 
	
	
	public Parameter parseAddition(String equation) {
			String[] input = equation.split("\\+");
			if(input[0].trim().equals("") || input.length<2) {
				logger.log(Level.WARNING, MESSAGE);
				return new Parameter("", "", "");
			}
			
			return new Parameter(input[0].trim() , input[1].trim(), "+");
	}
	
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
	public Parameter parseMultiplication(String equation) {
		String[] input = equation.split("\\*");
		if(input[0].trim().equals("") || input.length<2) {
			logger.log(Level.WARNING, MESSAGE);
			return new Parameter("", "", "");
		}
		return new Parameter(input[0].trim() , input[1].trim(), "*");
}
	public Parameter parseDivison(String equation) {
		String[] input = equation.split("/");
		if(input[0].trim().equals("") || input.length<2) {
			logger.log(Level.WARNING, MESSAGE);
			return new Parameter("", "", "");
		}
		return new Parameter(input[0].trim() , input[1].trim(), "/");
}

	public Parameter parseInput(String equation) {
			if(equation.contains("*")) {
				return parseMultiplication(equation);
			} else if(equation.contains("/")) {
				return parseDivison(equation);
			} else if(equation.contains("+")) {
				return parseAddition(equation);
			}else if(equation.contains("-")) {
				return parseSubtraction(equation);
			}
			return new Parameter("", "", "");
	}
}

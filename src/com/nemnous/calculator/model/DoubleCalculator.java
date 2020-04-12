package com.nemnous.calculator.model;

import com.nemnous.calculator.exceptions.InvalidArgumentsException;
import com.nemnous.calculator.interfaces.Calculable;

public class DoubleCalculator implements Calculable<Double> {
	
	public static final String REG_EX = "[+-]?([0-9]*[.])?[0-9]+";

	@Override
	public Double add(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Double value only");
		}
		
		if(operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments can't be Empty.");
		}
		Double arg1 = Double.parseDouble(operandA);
		Double arg2 = Double.parseDouble(operandB);
		return  arg1 + arg2;
	}

	@Override
	public Double subtract(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Double values only");
		}
		
		if(operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments can't be Empty.");
		}
		Double arg1 = Double.parseDouble(operandA);
		Double arg2 = Double.parseDouble(operandB);
		return  arg1 - arg2;
	}

	@Override
	public Double multiply(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Double value only");
		}
		
		if(operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments cannot be Empty.");
		}
		Double arg1 = Double.parseDouble(operandA);
		Double arg2 = Double.parseDouble(operandB);
		return  arg1 * arg2;
	}

	@Override
	public Double divide(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Double values only");
		}
		
		if(operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments cannot be Empty.");
		}
		Double arg1 = Double.parseDouble(operandA);
		Double arg2 = Double.parseDouble(operandB);
		if(arg2 == 0) {
			throw new InvalidArgumentsException("Infinity. Divided by Zero");
		}
		return  arg1 / arg2;
	}
}

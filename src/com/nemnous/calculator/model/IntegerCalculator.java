package com.nemnous.calculator.model;

import com.nemnous.calculator.exceptions.InvalidArgumentsException;
import com.nemnous.calculator.interfaces.Calculable;

public class IntegerCalculator implements Calculable<Integer> {
	public static final String REG_EX = "[+-]?\\d+";
	@Override
	public Integer add(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Integer Values only");
		}
		if(operandA.length() > 9 || operandB.length() > 9) {
			throw new InvalidArgumentsException("Exceeds size of int");
		}
		
		if(operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments can't be Empty.");
		}
		int arg1 = Integer.parseInt(operandA);
		int arg2 = Integer.parseInt(operandB);
		return  arg1 + arg2;
	}

	@Override
	public Integer subtract(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Integer Values only");
		}
		if(operandA.length() > 9 || operandB.length() > 9) {
			throw new InvalidArgumentsException("Exceeds size of int");
		}
		
		if(operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments can't be Empty.");
		}
		int arg1 = Integer.parseInt(operandA);
		int arg2 = Integer.parseInt(operandB);
		return  arg1 - arg2;
	}

	@Override
	public Integer multiply(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Integer values only");
		}
		if(operandA.length() > 9 || operandB.length() > 9) {
			throw new InvalidArgumentsException("Exceeds the size of int");
		}
		
		if(operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments cannot be Empty.");
		}
		int arg1 = Integer.parseInt(operandA);
		int arg2 = Integer.parseInt(operandB);
		return  arg1 * arg2;
	}

	@Override
	public Integer divide(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Integer values only");
		}
		if(operandA.length() > 9 || operandB.length() > 9) {
			throw new InvalidArgumentsException("Exceeds the size of int");
		}
		
		if(operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments cannot be Empty.");
		}
		int arg1 = Integer.parseInt(operandA);
		int arg2 = Integer.parseInt(operandB);
		return  arg1 / arg2;
	}




}

package com.nemnous.calculator.model;

import com.nemnous.calculator.exceptions.InvalidArgumentsException;
import com.nemnous.calculator.interfaces.Calculable;

public class FloatCalculator implements Calculable<Float> {
	
	public static final String REG_EX = "[+-]?([0-9]*[.])?[0-9]+";

	@Override
	public Float add(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter float values only");
		}
		
		if( operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments can't be Empty.");
		}
		float arg1 = Float.parseFloat(operandA);
		float arg2 = Float.parseFloat(operandB);
		return  arg1 + arg2;
	}

	@Override
	public Float subtract(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter float values only");
		}
		
		if(operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments can't be Empty.");
		}
		float arg1 = Float.parseFloat(operandA);
		float arg2 = Float.parseFloat(operandB);
		return  arg1 - arg2;
	}

	@Override
	public Float multiply(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Float values only");
		}
		
		if( operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments cannot be Empty.");
		}
		float arg1 = Float.parseFloat(operandA);
		float arg2 = Float.parseFloat(operandB);
		return  arg1 * arg2;
	}

	@Override
	public Float divide(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Float values only");
		}
		
		if( operandA.equals("") || operandB.equals("")) {
			throw new InvalidArgumentsException("Arguments cannot be Empty.");
		}
		float arg1 = Float.parseFloat(operandA);
		float arg2 = Float.parseFloat(operandB);
		if(arg2 == 0) {
			throw new InvalidArgumentsException("Infinity. Divided by Zero");
		}
		return  arg1 / arg2;
	}
}

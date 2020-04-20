package com.nemnous.calculator.model;

import com.nemnous.calculator.exceptions.InvalidArgumentsException;
import com.nemnous.calculator.interfaces.Calculable;

/**
 * This class implements the Calculable Interface.
 * This class handles operations performed on Double values.
 * @author nemnous.
 *
 */
public class DoubleCalculator implements Calculable<Double> {
	
	public static final String REG_EX = "[+-]?([0-9]*[.])?[0-9]+";

	/**
	 * This method adds the values from given Parameter Object.
	 * @param operands for addition operations are given as object.
	 * @throws InvalidArgumentsExeption if user enters values other
	 * than float or empty operands.
	 */
	@Override
	public Double add(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Double value only");
		}
		
		Double arg1 = Double.parseDouble(operandA);
		Double arg2 = Double.parseDouble(operandB);
		return  arg1 + arg2;
	}
	
	/**
	 * This method subtracts the values from given Parameter Object.
	 * @param operands for substraction operations are given as object.
	 * @throws InvalidArgumentsExeption if user enters values other
	 * than float or empty operands.
	 */
	@Override
	public Double subtract(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Double values only");
		}
		
		Double arg1 = Double.parseDouble(operandA);
		Double arg2 = Double.parseDouble(operandB);
		return  arg1 - arg2;
	}
	
	/**
	 * This method multiplies the values from given Parameter Object.
	 * @param operands for multiplication operations are given as object.
	 * @throws InvalidArgumentsExeption if user enters values other
	 * than float or empty operands.
	 */
	@Override
	public Double multiply(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Double value only");
		}
		Double arg1 = Double.parseDouble(operandA);
		Double arg2 = Double.parseDouble(operandB);
		return  arg1 * arg2;
	}

	/**
	 * This method divides the values from given Parameter Object.
	 * @param operands for division operations are given as object.
	 * @throws InvalidArgumentsExeption if user enters values other
	 * than float or empty operands or when divided by zero.
	 */
	@Override
	public Double divide(Parameter param) {
		String operandA = param.getOperandA();
		String operandB = param.getOperandB();
		if (!operandA.matches(REG_EX) || !operandB.matches(REG_EX)) {
			throw new InvalidArgumentsException("Enter Double values only");
		}
		Double arg1 = Double.parseDouble(operandA);
		Double arg2 = Double.parseDouble(operandB);
		if(arg2 == 0) {
			throw new InvalidArgumentsException("Infinity. Divided by Zero");
		}
		return  arg1 / arg2;
	}
}

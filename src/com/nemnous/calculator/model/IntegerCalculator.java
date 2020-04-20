package com.nemnous.calculator.model;

import com.nemnous.calculator.exceptions.InvalidArgumentsException;
import com.nemnous.calculator.interfaces.Calculable;


/**
 * This class implements the Calculable Interface.
 * This class handles operations performed on integer values.
 * @author nemnous.
 *
 */
public class IntegerCalculator implements Calculable<Integer> {
	public static final String REG_EX = "[+-]?\\d+";

	
	/**
	 * This method adds the values from given Parameter Object.
	 * @param operands for addition operations are given as object.
	 * @throws InvalidArgumentsExeption if user enters values other than integer
	 * or exceed the size of integer or Empty Arguments.
	 */
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
		
		
		int arg1 = Integer.parseInt(operandA);
		int arg2 = Integer.parseInt(operandB);
		return  arg1 + arg2;
	}
	
	/**
	 * This method subtracts the values from given Parameter Object.
	 * @param operands for substraction operations are given as object.
	 * @throws InvalidArgumentsExeption if user enters values other than integer
	 * or exceed the size of integer or Empty Arguments.
	 */
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
		int arg1 = Integer.parseInt(operandA);
		int arg2 = Integer.parseInt(operandB);
		return  arg1 - arg2;
	}
	
	/**
	 * This method multiplies the values from given Parameter Object.
	 * @param operands for multiplication operations are given as object.
	 * @throws InvalidArgumentsExeption if user enters values other than integer
	 * or exceed the size of integer or Empty Arguments.
	 */
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
		int arg1 = Integer.parseInt(operandA);
		int arg2 = Integer.parseInt(operandB);
		return  arg1 * arg2;
	}

	/**
	 * This method divides the values from given Parameter Object.
	 * @param operands for division operations are given as object.
	 * @throws InvalidArgumentsExeption if user enters values other than integer
	 * or exceed the size of integer or Empty Arguments.
	 * @throws ArithmeticException when divided by Zero.
	 */
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
		int arg1 = Integer.parseInt(operandA);
		int arg2 = Integer.parseInt(operandB);
		return  arg1 / arg2;
	}

}

package com.nemnous.calculator.model;

/**
 * class Parameter.
 * Contains the operands and operator handled from
 * a given equation.
 * @author nemnous.
 *
 */
public class Parameter {
	private String operandA;
	private String operandB;
	private String operator;

	/**
	 * Parameterized constructor to initialize values.
	 * @param operandA
	 * @param operandB
	 * @param operator
	 */
	public Parameter(String operandA, String operandB, String operator) {
		this.operandA = operandA;
		this.operandB = operandB;
		this.operator = operator;
	}
	
	/**
	 * getter method for operandB.
	 * @return
	 */
	public String getOperandB() {
		return operandB;
	}
	
	/**
	 * setter method for operandB.
	 * @param operandB
	 */
	public void setOperandB(String operandB) {
		this.operandB = operandB;
	}

	/**
	 * getter method for operandA.
	 * @return
	 */
	public String getOperandA() {
		return operandA;
	}

	/**
	 * setter method for operandA.
	 * @param operandA
	 */
	public void setOperandA(String operandA) {
		this.operandA = operandA;
	}

	/**
	 * getter method for operator
	 * @return
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * setter method for operator.
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * To String method for the class.
	 */
	@Override
	public String toString() {
		return operandA + " " +  operator + " " + operandB;
	}

}

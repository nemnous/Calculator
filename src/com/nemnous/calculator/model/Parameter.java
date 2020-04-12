package com.nemnous.calculator.model;

public class Parameter {
	private String operandA;
	private String operandB;
	private String operator;


	public Parameter(String operandA, String operandB, String operator) {
		this.operandA = operandA;
		this.operandB = operandB;
		this.operator = operator;
	}

	public String getOperandB() {
		return operandB;
	}

	public void setOperandB(String operandB) {
		this.operandB = operandB;
	}

	public String getOperandA() {
		return operandA;
	}

	public void setOperandA(String operandA) {
		this.operandA = operandA;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return operandA + " " +  operator + " " + operandB;
	}

}

package com.nemnous.calculator.interfaces;

import com.nemnous.calculator.model.Parameter;

/**
 * Interface for Calculator.
 * Contains the elementary methods like
 * addition, substraction, multiplication
 * division
 * @author nemnous
 *
 * @param <T> Given respective Datatypes as parameter.
 */
public interface Calculable<T extends Number> {
	/**
	 * for addition operation.
	 * @param param Parameter Object.
	 * @return result of addition of operands.
	 */
	public T add(Parameter param);
	/**
	 * for Substraction operation.
	 * @param param Parameter object.
	 * @return result of substraction of operands.
	 */
	public T subtract(Parameter param);
	/**
	 * for multiplication operation.
	 * @param param Parameter object.
	 * @return result of multiplication of operands.
	 */
	public T multiply(Parameter param);
	/**
	 * for division operation.
	 * @param param Parameter object
	 * @return result of division of operands.
	 */
	public T divide(Parameter param);
}

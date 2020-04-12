package com.nemnous.calculator.interfaces;

import com.nemnous.calculator.model.Parameter;

public interface Calculable<T extends Number> {
	public T add(Parameter param);
	public T subtract(Parameter param);
	public T multiply(Parameter param);
	public T divide(Parameter param);
}

package com.nemnous.calculator;

import com.nemnous.calculator.interfaces.InputReader;
import com.nemnous.calculator.service.ConsoleReader;

public class CalculatorLauncher {
	public static void main(String[] args) {
		InputReader reader = new ConsoleReader();
		reader.read();
	}
}

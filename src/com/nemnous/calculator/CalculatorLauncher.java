package com.nemnous.calculator;

import com.nemnous.calculator.interfaces.InputReader;
import com.nemnous.calculator.service.ConsoleReader;

/**
 * This is the Driver class for the Application.
 * @author nemnous.
 *
 */
public class CalculatorLauncher {
	/**
	 * Main method Application starts from here.
	 * @param args
	 */
	public static void main(String[] args) {
		InputReader reader = new ConsoleReader();
		reader.read();
	}
}

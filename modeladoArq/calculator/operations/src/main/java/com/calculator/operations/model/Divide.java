package com.calculator.operations.model;

import java.io.Serializable;

/**
 * @author Makayppe
 *
 */

public class Divide implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 712611580170489833L;
	private NumberCalc number1;
	private NumberCalc number2;
	
	public Divide(NumberCalc number1, NumberCalc number2) {
		super();
		this.number1 = number1;
		this.number2 = number2;
	}

	public NumberCalc getNumber1() {
		return number1;
	}

	public void setNumber1(NumberCalc number1) {
		this.number1 = number1;
	}

	public NumberCalc getNumber2() {
		return number2;
	}

	public void setNumber2(NumberCalc number2) {
		this.number2 = number2;
	}
		
}

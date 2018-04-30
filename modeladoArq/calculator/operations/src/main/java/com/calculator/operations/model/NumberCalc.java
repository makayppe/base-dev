/**
 * 
 */
package com.calculator.operations.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * @author marco.caipe
 *
 */
public class NumberCalc implements Serializable {

	/**
	 * 
	 */
	private String splitCharacter = "/";

	private static final long serialVersionUID = 8341639900567763235L;

	@NotNull
	private int[] operators;

	public int[] getNumber() {
		return operators;
	}

	public String setNumber(String operators, String operation) {
		String returnCode = "";
		int i = 0;
		String splitInitial = "/";
		splitInitial = splitInitial.concat(operation);
		operators = operators.replace(splitInitial, "");
		String[] splitTemp = operators.split(splitCharacter);
		int[] intOperators = new int[splitTemp.length];

		if (intOperators.length <= 1) {
			returnCode = "201";
			return returnCode;
		}

		try {
			for (String varTemp : splitTemp) {
				intOperators[i] = Integer.parseInt(varTemp.trim());
				i++;
			}
			this.operators = intOperators;
			returnCode = "200";
		} catch (Exception e) {
			returnCode = "202";
		}
		return returnCode;
	}

}

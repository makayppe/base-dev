/**
 * 
 */
package com.calculator.operations.component;

/**
 * @author marco.caipe
 *
 */
public class DivisionOperation {

	public int divide(int[] operands) throws ArithmeticException {
		int result = operands[0];

		for (int temp = 1; temp < operands.length; temp++) {

			result /= operands[temp];
		}
		return result;
	}
}

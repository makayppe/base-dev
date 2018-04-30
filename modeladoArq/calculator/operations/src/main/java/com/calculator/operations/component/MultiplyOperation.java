/**
 * 
 */
package com.calculator.operations.component;

/**
 * @author marco.caipe
 *
 */
public class MultiplyOperation {

	public int multiply(int[] operands) {
		int result = 1;
		for (int temp : operands) {
			result *= temp;
		}
		return result;
	}
}

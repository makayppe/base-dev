/**
 * 
 */
package com.calculator.operations.component;

/**
 * @author marco.caipe
 *
 */
public class Addition {
	
	public int sum(int[] operands) {
		int result = 0;
		for(int temp : operands) {
			result += temp;
		}
		return result;
	}

}

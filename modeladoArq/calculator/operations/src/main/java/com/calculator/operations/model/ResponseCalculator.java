/**
 * 
 */
package com.calculator.operations.model;

/**
 * @author marco.caipe
 *
 */
public class ResponseCalculator {

	public String code;
	public String status;
	public String result;

	public ResponseCalculator(String code, String status,String operationResult) {
		super();
		this.code = code;
		this.status = status;
		this.result = operationResult;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

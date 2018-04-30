/**
 * 
 */
package com.calculator.operations.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import com.calculator.operations.component.Addition;
import com.calculator.operations.component.DivisionOperation;
import com.calculator.operations.component.MultiplyOperation;
import com.calculator.operations.component.Substraction;
import com.calculator.operations.model.NumberCalc;
import com.calculator.operations.model.ResponseCalculator;

/**
 * @author marco.caipe
 *
 */

@Controller
public class CalculatorController {

	/**
	 * 
	 * 
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);
	private static final String errorOperatorsIn = "Ha ocurrido un error con los datos ingresados, "
			+ "por favor ingrese datos de tipo entero positivos o negativos ejemplo: /5/-8";
	private static final String errorOperatorNumber = "Se requieren al menos dos operadores.";
	private static final String statusOk = "OK";
	private static final String statusError = "Error";
	private static final String zeroDivError = "No se puede dividir por 0";

	@RequestMapping(value = { "/add/**" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ResponseCalculator> additionOperation(HttpServletRequest request) {
		LOGGER.info("Recibiendo petición para realizar suma");
		ResponseEntity<ResponseCalculator> response = null;
		String inOperators = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

		Addition addition = new Addition();
		NumberCalc numberCalc = new NumberCalc();
		ResponseCalculator responseCalculator;
		String operatorsStatus = numberCalc.setNumber(inOperators, "add/");

		if (operatorsStatus.equals("200")) {
			int operationResult = addition.sum(numberCalc.getNumber());
			responseCalculator = new ResponseCalculator(operatorsStatus, statusOk, String.valueOf(operationResult));
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		} else if (operatorsStatus.equals("202")) {
			responseCalculator = new ResponseCalculator(operatorsStatus, statusError, errorOperatorsIn);
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		} else {
			responseCalculator = new ResponseCalculator(operatorsStatus, statusError, errorOperatorNumber);
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(value = { "/subs/**" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ResponseCalculator> differenceOperation(HttpServletRequest request) {
		LOGGER.info("Recibiendo petición para realizar resta");
		ResponseEntity<ResponseCalculator> response = null;
		String inOperators = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

		Substraction substraction = new Substraction();
		NumberCalc numberCalc = new NumberCalc();
		ResponseCalculator responseCalculator;
		String operatorsStatus = numberCalc.setNumber(inOperators, "subs/");

		if (operatorsStatus.equals("200")) {
			int operationResult = substraction.diference(numberCalc.getNumber());
			responseCalculator = new ResponseCalculator(operatorsStatus, statusOk, String.valueOf(operationResult));
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		} else if (operatorsStatus.equals("202")) {
			responseCalculator = new ResponseCalculator(operatorsStatus, statusError, errorOperatorsIn);
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		} else {
			responseCalculator = new ResponseCalculator(operatorsStatus, statusError, errorOperatorNumber);
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(value = { "/mult/**" }, method = RequestMethod.GET, produces = "application/json")

	public ResponseEntity<ResponseCalculator> multiplyOperation(HttpServletRequest request) {
		LOGGER.info("Recibiendo petición para realizar multiplicación");
		ResponseEntity<ResponseCalculator> response = null;
		String inOperators = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

		MultiplyOperation multiplication = new MultiplyOperation();
		NumberCalc numberCalc = new NumberCalc();
		ResponseCalculator responseCalculator;
		String operatorsStatus = numberCalc.setNumber(inOperators, "mult/");

		if (operatorsStatus.equals("200")) {
			int operationResult = multiplication.multiply(numberCalc.getNumber());
			responseCalculator = new ResponseCalculator(operatorsStatus, statusOk, String.valueOf(operationResult));
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		} else if (operatorsStatus.equals("202")) {
			responseCalculator = new ResponseCalculator(operatorsStatus, statusError, errorOperatorsIn);
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		} else {
			responseCalculator = new ResponseCalculator(operatorsStatus, statusError, errorOperatorNumber);
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(value = { "/div/**" }, method = RequestMethod.GET, produces = "application/json")

	public ResponseEntity<ResponseCalculator> divisioOperation(HttpServletRequest request) {
		LOGGER.info("Recibiendo petición para realizar división");
		ResponseEntity<ResponseCalculator> response = null;
		String inOperators = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

		DivisionOperation divisionOperation = new DivisionOperation();
		NumberCalc numberCalc = new NumberCalc();
		ResponseCalculator responseCalculator;
		String operatorsStatus = numberCalc.setNumber(inOperators, "div/");

		if (operatorsStatus.equals("200")) {
			try {
				int operationResult = divisionOperation.divide(numberCalc.getNumber());
				responseCalculator = new ResponseCalculator(operatorsStatus, statusOk, String.valueOf(operationResult));
				response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
			} catch (ArithmeticException e) {
				operatorsStatus = "203";
				responseCalculator = new ResponseCalculator(operatorsStatus, statusError, zeroDivError);
				response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
				return response;
			}

		} else if (operatorsStatus.equals("202")) {
			responseCalculator = new ResponseCalculator(operatorsStatus, statusError, errorOperatorsIn);
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		} else {
			responseCalculator = new ResponseCalculator(operatorsStatus, statusError, errorOperatorNumber);
			response = new ResponseEntity<ResponseCalculator>(responseCalculator, HttpStatus.OK);
		}
		return response;
	}

}

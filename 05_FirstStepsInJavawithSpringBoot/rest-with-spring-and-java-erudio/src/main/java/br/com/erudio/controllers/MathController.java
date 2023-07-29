package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumericConverter;
import br.com.erudio.exceptions.DividendCannotBeZeroException;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	//private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/{operation}/{numberOne}/{numberTwo}")
	public Double resultCalc (
			@PathVariable("operation") String operation,
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) throws Exception  {
		
		if (!NumericConverter.isNumeric(numberOne) || !NumericConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		Double result = 0D;
		
		switch(operation) {
		case "sum":
			result = NumericConverter.convertToDouble(numberOne) + NumericConverter.convertToDouble(numberTwo);
			break;
		case "subtract":
			result = NumericConverter.convertToDouble(numberOne) - NumericConverter.convertToDouble(numberTwo);
			break;
		case "multiply":
			result = NumericConverter.convertToDouble(numberOne) * NumericConverter.convertToDouble(numberTwo);
			break;
		case "divide":
			if (NumericConverter.convertToDouble(numberTwo) == 0) {
				throw new DividendCannotBeZeroException("Dividend cannot be zero");
			}
			result = NumericConverter.convertToDouble(numberOne) / NumericConverter.convertToDouble(numberTwo);
			break;
		default:
			result = 0D;
		}
		
		return result;
				
	}
	
	/*
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum (
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) throws Exception  {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
				
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
		
	}

	@GetMapping("/subtract/{numberOne}/{numberTwo}")
	public Double subtract(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("subtract operation - Please set a numeric value");
		}
		
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@GetMapping("/multiply/{numberOne}/{numberTwo}")
	public Double multiply(
		@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("multiply operation - Please set a numerica value");
		}
		
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@GetMapping("/divide/{numberOne}/{numberTwo}")
	public Double divide(
			@PathVariable("numberOne") String numberOne,
		 @PathVariable("numberTwo")	String numberTwo
			) {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("divider operation - Please set a numeric value");
		}
		
		if (convertToDouble(numberTwo) == 0) {
			throw new DividendCannotBeZeroException("Dividend cannot be zero");
		}
		
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
		
	}
	
	
	
	
	
	
	*/
	
	
	
	
	
	
	
	
	 

}

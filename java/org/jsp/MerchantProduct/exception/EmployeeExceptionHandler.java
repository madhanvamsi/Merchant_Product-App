package org.jsp.MerchantProduct.exception;

import org.jsp.MerchantProduct.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler 
  {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String >> IdNotFoundException(IdNotFoundException exception)
	{
		ResponseStructure<String > structure=new ResponseStructure<>();
		structure.setData("Employee notfound");
		structure.setMessage(exception.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseStructure<String >> InvalidCredentialsException(InvalidCredentialsException exception)
	{
		ResponseStructure<String > structure=new ResponseStructure<>();
		structure.setData("Employee notfound");
		structure.setMessage(exception.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}

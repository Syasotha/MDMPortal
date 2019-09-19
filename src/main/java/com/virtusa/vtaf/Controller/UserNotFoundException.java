package com.virtusa.vtaf.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public UserNotFoundException() {
		super();
	}
	
	public UserNotFoundException(String string) {
		super(string);
	}

}

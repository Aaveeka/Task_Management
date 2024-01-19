package com.org.taskManageement.cException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptions extends RuntimeException{
	public ResourceNotFoundExceptions(String message) {
		
		
		super(message);
	}

}

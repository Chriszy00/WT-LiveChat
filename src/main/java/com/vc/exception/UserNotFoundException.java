package com.vc.exception;

public class UserNotFoundException extends RuntimeException{

	   /**
	 * 
	 */
	private static final long serialVersionUID = 8330155363020256400L;

	public UserNotFoundException(Long id){
		   super("Could not found the user with id "+ id);
	    }
}
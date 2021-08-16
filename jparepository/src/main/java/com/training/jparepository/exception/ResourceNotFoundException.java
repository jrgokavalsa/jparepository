package com.training.jparepository.exception;

public class ResourceNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 3396738836251467830L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}

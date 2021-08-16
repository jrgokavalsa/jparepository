package com.training.jparepository.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1197381571783540130L;

	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}

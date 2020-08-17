package model.exceptions;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	// Construtor
	public DomainException(String msg) {
		super(msg);
	}

}

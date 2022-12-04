package model.exceptions;

public class UserChoiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UserChoiceException () {
		super("Escolha inválida. digite números de 1 a 3.");
	}

}

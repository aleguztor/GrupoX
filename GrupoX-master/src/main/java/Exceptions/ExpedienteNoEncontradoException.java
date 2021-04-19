package Exceptions;

public class ExpedienteNoEncontradoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExpedienteNoEncontradoException(String msg) {
		super(msg);
	}

	public ExpedienteNoEncontradoException() {
		super();
	}
}

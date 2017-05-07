package project.app;

public class OperationNotAllowedException extends Exception {

	public OperationNotAllowedException(String errorMsg) {
		super(errorMsg);
	}

}

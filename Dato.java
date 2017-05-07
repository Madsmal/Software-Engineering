package project.app;

public class Dato {

	public String Dato;


	public Dato(String Dato) {
		this.Dato = Dato;

	}
	
	public void InvalidDato() throws OperationNotAllowedException {
		if (Dato.length() != 10) {
			throw new OperationNotAllowedException("Dato skal være dd-MM-yyyy");
		}
	}
	
}

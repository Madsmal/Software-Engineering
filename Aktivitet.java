package project.app;

import java.util.ArrayList;

public class Aktivitet {
	
	public String Navn;
	public String StartDato;
	public String SlutDato;
	ArrayList<Medarbejder> Medarbejder;
	Projekt projekt;
	
	public Aktivitet(String Navn, String StartDato, String SlutDato){
		this.Navn = Navn;
		this.StartDato = StartDato;
		this.SlutDato = SlutDato;
	}
	public void addMedarbejder(Medarbejder med) throws NoInputException {
		if (med == null) {
			throw new NoInputException("Invalid input - Medarbejder");
		} else {
			Medarbejder.add(med);

		}
	}

	// Getters og setters
	public String getNavn() {
		return Navn;
	}
	
	public boolean belongs(Projekt projekt) {
		if (projekt == this.projekt) {
			return true;
		}
		return false;
	}


}

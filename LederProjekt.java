package project.app;

import java.util.ArrayList;
import java.util.List;

public class LederProjekt {
	
	public String Navn;
	public String Beskrivelse;
	public String StartDato;
	public String SlutDato;
	public SoftwareSystem System;
	
	List<Aktivitet> Aktiviteter = new ArrayList<Aktivitet>();
	
	
	public LederProjekt(String Navn, String Beskrivelse, String StartDato, SoftwareSystem System) {
		this.Navn = Navn;
		this.Beskrivelse = Beskrivelse;
		this.StartDato = StartDato;
		this.System = System;
		
	}
	
	public void LavAktivitet(String Navn, String StartDato, String SlutDato) {
		this.Navn = Navn;
		this.StartDato = StartDato;
		this.SlutDato = SlutDato;
		// Hvis konstruktør indeholder null --> return NoInputException
		
	}
	
	

}

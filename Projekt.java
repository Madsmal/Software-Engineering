package project.app;

import java.util.ArrayList;
import java.util.List;

public class Projekt {
	
	SoftwareSystem System;
	public String ProjektNr;
	public String Titel;
	public String Beskrivelse;
	public String StartDato;
	public String SlutDato;
	public String Projektleder;
	public Medarbejder Leder;
	public boolean harLeder;
	
	public List<Medarbejder> Medarbejder = new ArrayList<Medarbejder>();
	public List<Projekt> Projekts = new ArrayList<Projekt>();
	public List<Aktivitet> Aktiviteter = new ArrayList<Aktivitet>();

	public Projekt(String Titel, String Beskrivelse, String Projektleder, String StartDato, SoftwareSystem System) {
		this.Titel = Titel;
		this.Beskrivelse = Beskrivelse;
		this.StartDato = StartDato;
		this.Projektleder = Projektleder;
		this.System = System;
	}
	
	public List<Projekt> setProjektleder(String projekt, String Projektleder) throws NoInputException {
		for (int i = 0; i < Projekts.size(); i++) {
			if (Projekts.get(i).Titel.contains(projekt)) {
				Projekts.add(new Projekt("Titel", "Beskrivelse", Projektleder, "01-01-2017", System));
			}
		}
		return Projekts;
	}
	
	
	public void addMedarbejder(Medarbejder ID) {
		Medarbejder.add(ID);
	}
	
	public void createProjektNr() {
		ProjektNr = System.setProjektNr();
	}
	
	public String getProjektNr() {
		return ProjektNr;
	}

	// public void setLeader(Medarbejder eks1) {
		// TODO Auto-generated method stub
		
	// }

	public String getStartDato() {
		// TODO Auto-generated method stub
		return StartDato;
	}

	public String getBeskrivelse() {
		// TODO Auto-generated method stub
		return Beskrivelse;
	}
	
	public void setTitel(String Titel) {
		this.Titel = Titel;
	}
	
	public void setBeskrivelse(String Beskrivelse) {
		this.Beskrivelse = Beskrivelse; 
	}

	public String getTitel() {
		// TODO Auto-generated method stub
		return Titel;
	}

	public Object getLeder() {
		// TODO Auto-generated method stub
		return Leder;
	}
	
	public void addAktivitet(Aktivitet akt) {
		Aktiviteter.add(akt);
	}

	public void setLeader(Medarbejder eks1) {
		// TODO Auto-generated method stub
		
	}
	

}

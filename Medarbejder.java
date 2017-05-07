package project.app;

import java.util.List;

public class Medarbejder {
	public SoftwareSystem System;
	public String Initialer;
	public String StartDato;
	public String SlutDato;
	public String Titel;
	public String Beskrivelse;
	
	public List<Projekt> myProjects;
	public List<Aktivitet> myActivities;
	public List<LederProjekt> myLeaderProjects;
	
	public Medarbejder(String Initialer, SoftwareSystem System) {
	this.Initialer = Initialer;
	this.System = System;
	
	
	}

	public void OpretProject(String Titel, String Beskrivelse, String StartDato, String SlutDato, SoftwareSystem System) {
		// Throw exceptions here
		
	}
	
	
	
	
	public String getInitialer() {
		return Initialer;
	}
	
}

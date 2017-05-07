package project.app;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import project.app.Medarbejder;
import project.app.NoInputException;
import project.app.OperationNotAllowedException;
import project.app.SoftwareSystem;

public class SampleDataSetup {
	
	SoftwareSystem System = new SoftwareSystem();
	Medarbejder eks1;
	Medarbejder eks2;
	Medarbejder eks3;
	Dato dato1;
	Dato dato2;
	Dato dato3;
	
	List<Projekt> Projekts = new ArrayList<Projekt>();
	
	
	@Before
	public void setUp() throws NoInputException, OperationNotAllowedException {
		
		eks1 = new Medarbejder("M.M",System);
		eks2 = new Medarbejder("O.I.P",System);
		eks3 = new Medarbejder("N.M",System);
		
		System.Medarbejder.add(eks1);
		System.Medarbejder.add(eks2);
		System.Medarbejder.add(eks3);
		
		dato1 = new Dato("01-01-1996");
		dato2 = new Dato("02-020-29995");
		dato3 = new Dato("22");


		eks1.OpretProject("Projekt1", "Beskrivelse1", "01-01-2016", "01-01-2020", System);
		System.Projekts.get(0).addMedarbejder(eks2);
		System.Medarbejder.get(0).myProjects.get(0).setLeader(eks1);

		
		System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet("Testss", "01-01-1996", "01-01-2000");
		System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet("Ayyyy", "01-01-202020", "02020202-2020202");
	}



	
	
	
}

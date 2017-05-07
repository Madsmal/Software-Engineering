package project.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import project.app.Medarbejder;
import project.app.NoInputException;
import project.app.OperationNotAllowedException;
import project.app.SoftwareSystem;

/**
 * This class contains tests, testing the functionality of adding employees to a
 * project
 */

public class TestAddEmployeeToProject {

	SoftwareSystem System = new SoftwareSystem();
	Medarbejder eks1;
	Medarbejder eks2;
	Medarbejder eks3;
	Dato dato1;
	Dato dato2;
	Dato dato3;

	@Before
	public void addEmployees() throws NoInputException, OperationNotAllowedException {
		eks1 = new Medarbejder("M.M",System);
		eks2 = new Medarbejder("O.I.P",System);
		eks3 = new Medarbejder("N.M",System);
		System.Medarbejder.add(eks1);
		System.Medarbejder.add(eks2);
		System.Medarbejder.add(eks3);
		
		dato1 = new Dato("01-01-1996");
		dato2 = new Dato("02-020-29995");
		dato3 = new Dato("22");
		eks1.OpretProject("Projekt1", "Beskrivelse1", "01-01-2016","01-01-2020", System);
	}

	/**
	 * Tests the scenario that the user wants to add an employee to a project
	 * using valid initials, while the project has no leader.
	 */
	@Test
	public void testAddValidEmployee() throws NoInputException {

		// Check that the project currently has only its creator in the list of
		// employees
		assertEquals(1, System.Projekts.get(0).Medarbejder.size());

		// Another employee is added to the project
		System.Medarbejder.get(0).myProjects.get(0).addMedarbejder(eks2);
		// system.projects.get(0).employees.add(e2);

		// Check that the employee has been added correctly
		assertEquals(2, System.Projekts.get(0).Medarbejder.size());
	}

	/**
	 * Tests the scenario that the user wants to add a non-existing employee to
	 * a project using valid initials, while the project has no leader.
	 */
	@Test
	public void testAddInvalidEmployee() throws NoInputException {

		// Check that the project currently has only its creator in the list of
		// employees
		assertEquals(1, System.Projekts.get(0).Medarbejder.size());

		// An non-existing employee, null, is added to the project
		System.Medarbejder.get(0).myProjects.get(0).addMedarbejder(null);
		fail("Should throw MissingInputException");
	}


}

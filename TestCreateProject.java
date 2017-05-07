package project.app;


// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

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
 * This class contains tests, testing the functionality of creating projects in
 * the system.
 */

public class TestCreateProject {

	SoftwareSystem System = new SoftwareSystem();
	Medarbejder eks1;
	Medarbejder eks2;
	Medarbejder eks3;

	@Before
	public void addEmployees() {
		eks1 = new Medarbejder("M.M", System);
		eks2 = new Medarbejder("O.I.P", System);
		eks3 = new Medarbejder("N.M",System);
		System.Medarbejder.add(eks1);
		System.Medarbejder.add(eks2);
		System.Medarbejder.add(eks3);
		// date1 = new GregorianCalendar(2011,Calendar.JANUARY,10);

	}

	/**
	 * Tests the scenario that the user wants to create a project while
	 * providing a project name, start date and information about its
	 * activities.
	 * 
	 * @throws MissingInputException
	 * @throws InvalidInputException 
	 */
	@Test
	public void testValidProject() throws NoInputException, OperationNotAllowedException {

		// Check that the system currently has no projects
		assertEquals(0, System.Projekts.size());
		
		// Employee creates a project with a name, date and information
		eks1.OpretProject("Test", "Deleted everything", "01-01-1996", null, System);

		// Check that the project has been created in the system
		assertEquals(1, System.Projekts.size());
		// assertEquals(1, system.projects.get(0).getProjectNumber());
		assertEquals("01-01-2016", System.Projekts.get(0).getStartDate());
		assertEquals("Just deleted everything", System.Projekts.get(0).getBeskrivelse());
		assertEquals("Heheoee", System.Projekts.get(0).getTitel());
	}

	/**
	 * Tests the scenario that the user wants to create a project without
	 * providing any information about it.
	 * @throws InvalidInputException 
	 */
	@Test
	public void testEmptyProject() throws NoInputException {
		// Check that the system currently has no projects
		// assertEquals(0, system.projects.size());

		// Employee creates a project without a name, a date and information
		// Calendar date1 = new GregorianCalendar(2011,Calendar.JANUARY,10);

		// Hvilken skal vi benytte?
		// e1.createProject();

		assertEquals(0, System.Projekts.size());

		try {
			eks1.OpretProject(null, null, null, null, System);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify project name, description and starting date", e.getMessage());
			assertEquals("Create project", e.getOperation());
			// Check that the project has not been created in the system
			assertEquals(0, System.Projekts.size());
		}
	}

	/**
	 * Tests the scenario that the user wants to create a project without
	 * providing a project name and information about its activities.
	 * 
	 * @throws MissingInputException
	 * @throws InvalidInputException 
	 */
	@Test
	public void testProjectWithoutNameAndDescription() throws NoInputException, OperationNotAllowedException {

		assertEquals(0, System.Projekts.size());
		// Employee creates a project without a name and information
		// Calendar date1 = new GregorianCalendar(2011,Calendar.JANUARY,10);

		// Hvilken skal vi benytte?
		// e1.createProject();
		try {
			eks1.OpretProject(null, null, "01-01-2015", null, System);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify project name, description and starting date", e.getMessage());
			assertEquals("Create project", e.getOperation());
			// Check that the project has not been created in the system
			assertEquals(0, System.Projekts.size());

		}
		// Check that the project has not been created in the system

	}

	/**
	 * Tests the scenario that the user wants to create a project without
	 * providing a start date and information about its activities.
	 * @throws InvalidInputException 
	 */
	@Test
	public void testProjectWithoutDateAndDescription() throws NoInputException {
		// Employee creates a project without a date and information
		assertEquals(0, System.Projekts.size());

		try {
			eks1.OpretProject("HHOHO", null, null, null, System);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify project name, description and starting date", e.getMessage());
			assertEquals("Create project", e.getOperation());
			// Check that the project has not been created in the system
			assertEquals(0, System.Projekts.size());

		}

	}

	/**
	 * Tests the scenario that the user wants to create a project without
	 * providing a start date and a project name.
	 * @throws InvalidInputException 
	 */
	@Test
	public void testProjectWithoutDateAndName() throws NoInputException {
		// Employee creates a project without a name and date
		assertEquals(0, System.Projekts.size());

		try {
			eks1.OpretProject(null, "Neat", null, null, System);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify project name, description and starting date", e.getMessage());
			assertEquals("Create project", e.getOperation());
			// Check that the project has not been created in the system
			assertEquals(0,System.Projekts.size());

		}

	}

	/**
	 * Tests the scenario that the user wants to create a project without
	 * providing a start date for the project.
	 * @throws InvalidInputException 
	 */
	@Test
	public void testProjectWithoutStartdate() throws NoInputException {
		// Employee creates a project without a date
		assertEquals(0, System.Projekts.size());

		try {
			eks1.OpretProject("Ayy", "LMAO", null, null, System);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify project name, description and starting date", e.getMessage());
			assertEquals("Create project", e.getOperation());
			// Check that the project has not been created in the system
			assertEquals(0, System.Projekts.size());

		}

	}

	/**
	 * Tests the scenario that the user wants to create a project without
	 * providing a project name.
	 * @throws InvalidInputException 
	 */
	@Test
	public void testProjectWithoutName() throws NoInputException {
		// Employee creates a project without a name
		// Calendar date1 = new GregorianCalendar(2011,Calendar.JANUARY,10);
		assertEquals(0, System.Projekts.size());

		try {
			eks1.OpretProject(null, "Nothing", "11-10-2010", null, System);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify project name, description and starting date", e.getMessage());
			assertEquals("Create project", e.getOperation());
			// Check that the project has not been created in the system
			assertEquals(0, System.Projekts.size());

		}

	}

	/**
	 * Tests the scenario that the user wants to create a project without
	 * providing information about its activities.
	 * @throws InvalidInputException 
	 */
	@Test
	public void testProjectWithoutDescription() throws NoInputException {
		// Employee creates a project without information
		// Calendar date1 = new GregorianCalendar(2011,Calendar.JANUARY,10);
		assertEquals(0, System.Projekts.size());

		try {
			eks1.OpretProject("U and I", null, "01-01-2001", null, System);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify project name, description and starting date", e.getMessage());
			assertEquals("Create project", e.getOperation());
			// Check that the project has not been created in the system
			assertEquals(0, System.Projekts.size());

		}

	}
}

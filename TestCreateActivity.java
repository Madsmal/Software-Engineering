package project.app;

import static org.junit.Assert.*;

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
 * This class contains tests, testing the functionality of creating activities
 * in the system.
 */

public class TestCreateActivity {

	SoftwareSystem System = new SoftwareSystem();
	Medarbejder eks1;
	Medarbejder eks2;
	Medarbejder eks3;
	Dato dato1;
	Dato dato2;
	Dato dato3;
	

	@Before
	public void addEmployees() throws NoInputException, OperationNotAllowedException {
		eks1 = new Medarbejder("M.M", System);
		eks2 = new Medarbejder("O.I.P", System);
		eks3 = new Medarbejder("N.M", System);
		
		System.Medarbejder.add(eks1); 
		System.Medarbejder.add(eks2);
		System.Medarbejder.add(eks3);
		
		dato1 = new Dato("01-01-1996");
		dato2 = new Dato("02-020-29995");
		dato3 = new Dato("22");
		
		eks1.OpretProject("Projekt1", "Beskrivelse1", "01-01-2016","01-01-2020", System);
		
		System.Projekts.get(0).addMedarbejder(eks2);
		System.Medarbejder.get(0).myProjects.get(0).setLeader(eks1);

	} 

	/**
	 * Tests the scenario that the user wants to create an activity while
	 * providing a name, start date and ending date.
	 * 
	 * @throws MissingInputException
	 * @throws InvalidInputException
	 */
	@Test
	public void testValidActivity() throws NoInputException, OperationNotAllowedException {

		// Checks that no activities exist in project version for e2 and leader
		// project version for e1
		assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
		assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());


		// Add activity to leader project
		System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet("Hehe", "05-05-2015", "05-05-2020");

		// Check that the activity has been added to the project list and the
		// leader project list
		assertEquals(1, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
		assertEquals(1, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

	}

	/**
	 * Tests the scenario that the user wants to create an activity without
	 * providing a name, start date and ending date.
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testEmptyActivity() throws NoInputException{

		// Checks that no activities exist in project version for e2 and leader
		// project version for e1
		assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
		assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		// Add invalid activity to leader project
		System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet(null, null, null);
		fail("Should throw MissingInputException");

	}

	/**
	 * Tests the scenario that the user wants to create an activity without
	 * providing a name and ending date.
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testActivityWithoutNameAndEnddate() throws NoInputException {

		// Checks that no activities exist in project version for e2 and leader
		// project version for e1
		assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
		assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

	
		try {
			// Add invalid activity to leader project
			System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet(null, "01-01-2016", null);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify activity name, starting and ending date", e.getMessage());
			assertEquals("Create activity", e.getOperation());
			// Check that the activity has not been created in the system
			// Check that the activity has not been added to the project list
			// and the leader project list
			assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
			assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		}

	}

	/**
	 * Tests the scenario that the user wants to create an activity without
	 * providing a name and ending date.
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testActivityWithoutNameAndStartdate() throws NoInputException {

		// Checks that no activities exist in project version for e2 and leader
		// project version for e1
		assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
		assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());


		try {
			// Add invalid activity to leader project
			System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet(null, null, "01-01-2020");
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify activity name, starting and ending date", e.getMessage());
			assertEquals("Create activity", e.getOperation());
			// Check that the activity has not been created in the system
			// Check that the activity has not been added to the project list
			// and the leader project list
			assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
			assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		}

	}

	/**
	 * Tests the scenario that the user wants to create an activity without
	 * providing a name and starting date.
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testActivityWithoutStartdateAndEnddate() throws NoInputException {

		// Checks that no activities exist in project version for e2 and leader
		// project version for e1
		assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
		assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		try {
			// Add invalid activity to leader project
		System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet("Ayyy", null, null);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify activity name, starting and ending date", e.getMessage());
			assertEquals("Create activity", e.getOperation());
			// Check that the activity has not been created in the system
			// Check that the activity has not been added to the project list
			// and the leader project list
			assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
			assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		}

	}

	/**
	 * Tests the scenario that the user wants to create an activity without
	 * providing a starting date and ending date.
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void TestActivityWithoutEnddate() throws NoInputException {

		// Checks that no activities exist in project version for e2 and leader
		// project version for e1
		assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
		assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		try {
			// Add invalid activity to leader project
			System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet("Test", "start", null);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify activity name, starting and ending date", e.getMessage());
			assertEquals("Create activity", e.getOperation());
			// Check that the activity has not been created in the system
			// Check that the activity has not been added to the project list
			// and the leader project list
			assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
			assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		}

	}

	/**
	 * Tests the scenario that the user wants to create an activity while
	 * providing a start date and ending date.
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testActivityWithoutName() throws NoInputException {

		// Checks that no activities exist in project version for e2 and leader
		// project version for e1
		assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
		assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		try {
			// Add invalid activity to leader project
			System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet(null, "01-01-2016", "01-01-2020");
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify activity name, starting and ending date", e.getMessage());
			assertEquals("Create activity", e.getOperation());
			// Check that the activity has not been created in the system
			// Check that the activity has not been added to the project list
			// and the leader project list
			assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
			assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		}

	}

	/**
	 * Tests the scenario that the user wants to create an activity while
	 * providing a name and ending date, but an invalid start date.
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testActivityWithoutStartdate() throws NoInputException {

		// Checks that no activities exist in project version for e2 and leader
		// project version for e1
		assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
		assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		try {
			// Add invalid activity to leader project
			System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet("Ayyy", null, "01-01-2020");
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please specify activity name, starting and ending date", e.getMessage());
			assertEquals("Create activity", e.getOperation());
			// Check that the activity has not been created in the system
			// Check that the activity has not been added to the project list
			// and the leader project list
			assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
			assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());


		}

	}

	/**
	 * Tests the scenario that the user wants to create an activity while
	 * providing a name, a start date and an ending date which lies before the
	 * start date
	 * 
	 * @throws MissingInputException
	 */
	@Test
	public void testActivityWithInvalidEndDate() throws NoInputException {

		try {
			// Add invalid activity to leader project
			System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet("HEHEHE", "01-01-1996", "01-01-2006");
			fail("Should throw InvalidDateException");
		} catch (NoInputException e) {
			assertEquals("Please specify a valid date", e.getMessage());
			assertEquals("Invalid date", e.getOperation());
			// Check that the activity has not been created in the system
			// Check that the activity has not been added to the project list
			// and the leader project list
			assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.size());
			assertEquals(0, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());

		}

	}

	/**
	 * Tests the scenario that the user wants to create an activity while
	 * providing a name, a start date and an ending date which lies after the
	 * ending date of the project
	 */
	@Test
	public void testActivityEndDateWithoutProjectEnd() throws NoInputException, OperationNotAllowedException {

		// Add activity to leader project

		System.Medarbejder.get(0).myLeaderProjects.get(0).LavAktivitet("HEHE", "11-11-1111", "22-22-2222");

		// Check that the system does not report invalid endDate

		// Check that the activity has not been added to the project list
		// and the
		// leader project list
		assertEquals(1, System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.size());
	}
}
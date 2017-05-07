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
 * This class contains tests, testing the functionality of assigning activities
 * to employees.
 */

public class TestAssignActivity extends SampleDataSetup {

	/**
	 * Tests the scenario that a leader wants to assign an activity to an
	 * employee who is available during the time of the activity
	 * 
	 * @throws MissingInputException
	 * @throws UnavailableEmployeeException
	 */
	@Test
	public void testValidEmployee() throws NoInputException {

		// Check that employee e2 has not been assigned any activities.
		assertEquals(0, System.Medarbejder.get(1).myActivities.size());
		// Check that the activity does not have any employees assigned to it
		assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.get(0).Medarbejder.size());

		// Add employee to activity
		System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.get(0).addMedarbejder(eks2);

		// Check that the employee has been added to the activity
		assertEquals(1, System.Medarbejder.get(1).myActivities.size());
		assertEquals(1, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.get(0).Medarbejder.size());

	}

	/**
	 * Tests the scenario that a leader wants to assign an activity to an
	 * employee who does not exist in the system
	 * 
	 * @throws UnavailableEmployeeException
	 */
	@Test
	public void testInvalidEmployee() throws NoInputException, OperationNotAllowedException {

		// Check that the activity does not have any employees assigned to it
		assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.get(0).Medarbejder.size());

		try {
			// Add invalid employee to activity
			System.Medarbejder.get(0).myLeaderProjects.get(0).Aktiviteter.get(0).addMedarbejder(null);
			fail("Should throw MissingInputException");
		} catch (NoInputException e) {
			assertEquals("Please select a valid employee", e.getMessage()); 
			assertEquals("Assign employee", e.getOperation());

			// Check that the activity still does not have any employees
			// assigned to it
			assertEquals(0, System.Medarbejder.get(1).myProjects.get(0).Aktiviteter.get(0).Medarbejder.size());

		}

	}


}
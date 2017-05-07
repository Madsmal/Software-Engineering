package project.app;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import project.app.InvalidInputException;
import project.app.MissingInputException;
import project.app.UnavailableEmployeeException;

/**
 * This class contains tests, testing the functionality of employees registering
 * work hours.
 */

public class TestRegisterWorkHours extends SampleDataSetup {

	/**
	 * Tests the scenario that the user wants to register 5.5 working hours to
	 * an activity that they have worked on today.
	 * 
	 * @throws InvalidInputException
	 * @throws MissingInputException
	 * @throws UnavailableEmployeeException
	 */
	@Test
	public void testValidActivityAndHours()
			throws MissingInputException, InvalidInputException, UnavailableEmployeeException {

		// e1 creates a new activity
		Calendar startAct = new GregorianCalendar(2016, Calendar.APRIL, 20);
		Calendar endAct = new GregorianCalendar(2016, Calendar.JUNE, 1);

		system.employees.get(0).myLeaderProjects.get(0).createActivity("Pizza", startAct, endAct);

		// e1 adds e2 to activity
		system.employees.get(0).myLeaderProjects.get(0).activities.get(2).addEmployee(e2);

		// The selected activity is the first activity in e2's WeekSchedule
		int actNumber = 1;

		// Check that the employee is affiliated with the selected activity
		assertTrue(system.employees.get(1).isAffiliated(actNumber));

		// The given number of working hours
		double hours = 5.5;

		// Register working hours in activity for e2's DaySchedule
		system.employees.get(1).registerHours(actNumber, hours);

		// Check that the correct hours are registered in e2's DaySchedule for
		// this day
		//
		// evt tag højde for summerede timer

		// Index of activity in the DaySchedule
		int k = system.employees.get(1).myDays[system.getDate()].activities.size() - 1;

		assertEquals(hours, system.employees.get(1).myDays[system.getDate()].workedHours.get(k),
				system.employees.get(1).myDays[system.getDate()].workedHours.get(k) - hours);

	}

	/**
	 * Tests the scenario that the user wants to register 6.5 working hours when
	 * they have not selected a
	 * 
	 * @throws MissingInputException
	 * @throws InvalidInputException
	 * @throws UnavailableEmployeeException 
	 */
	@Test
	public void testInvalidActivity() throws MissingInputException, InvalidInputException, UnavailableEmployeeException {

		// e1 creates a new activity
		Calendar startAct = new GregorianCalendar(2016, Calendar.APRIL, 20);
		Calendar endAct = new GregorianCalendar(2016, Calendar.JUNE, 1);

		system.employees.get(0).myLeaderProjects.get(0).createActivity("Pizza", startAct, endAct);

		// e1 adds e2 to activity
		system.employees.get(0).myLeaderProjects.get(0).activities.get(2).addEmployee(e2);

		// The selected activity is not in e2's WeekSchedule
		int actNumber = 3;

		// Check that the employee is not affiliated with the selected activity
		try { 
			assertFalse(system.employees.get(1).isAffiliated(actNumber));
		} catch (InvalidInputException e) {
			assertEquals("Please specify a valid activity", e.getMessage());
			assertEquals("Register work hours", e.getOperation());
		}

	}

	/**
	 * Tests the scenario that the user wants to create a project while
	 * providing a project name, start date and information about its
	 * activities.
	 * 
	 * @throws MissingInputException
	 * @throws InvalidInputException
	 * @throws UnavailableEmployeeException
	 */
	@Test
	public void testNegativeHours() throws MissingInputException, InvalidInputException, UnavailableEmployeeException {

		// e1 creates a new activity
		Calendar startAct = new GregorianCalendar(2016, Calendar.APRIL, 20);
		Calendar endAct = new GregorianCalendar(2016, Calendar.JUNE, 1);

		system.employees.get(0).myLeaderProjects.get(0).createActivity("Pizza", startAct, endAct);

		// e1 adds e2 to activity
		system.employees.get(0).myLeaderProjects.get(0).activities.get(2).addEmployee(e2);

		// The selected activity is the first activity in e2's WeekSchedule
		int actNumber = 1;

		// Check that the employee is affiliated with the selected activity
		assertTrue(system.employees.get(1).isAffiliated(actNumber));

		// The given number of working hours
		double hours = -5.5;

		try {
			// Register working hours in activity for e2's DaySchedule
			system.employees.get(1).registerHours(actNumber, hours);
			fail("Should throw MissingInputException");
		} catch (InvalidInputException e) {
			assertEquals("Please specify valid work hours", e.getMessage());
			assertEquals("Register work hours", e.getOperation());
			// Check that the no hours are registered in e2's DaySchedule for
			// this day
			//

			// Size of number of work hour registrations in DaySchedule			
			int k = system.employees.get(1).myDays[system.getDate()].workedHours.size();

			assertEquals(0, k);
		}

	}

}

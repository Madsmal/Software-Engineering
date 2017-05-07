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

import project.app.Employee;
import project.app.InvalidInputException;
import project.app.MissingInputException;
import project.app.UnavailableEmployeeException;

/**
 * This class contains tests, testing the functionality of checking the time
 * spent on an entire project, and on each activity.
 */

public class TestCheckHoursPerActivityInProject extends SampleDataSetup {

	@Before
	public void addActivities() throws MissingInputException, InvalidInputException, UnavailableEmployeeException {

		Employee e3 = new Employee("I.B.", system);
		system.employees.add(e3);

		// Leader e1 creates a new activity
		Calendar startAct = new GregorianCalendar(2016, Calendar.APRIL, 20);
		Calendar endAct = new GregorianCalendar(2016, Calendar.JUNE, 1);

		// Initialise three activities and add them to e2 and e3
		int counter;
		String name = "Act";
		for (counter = 2; counter < 5; counter++) {
			system.employees.get(0).myLeaderProjects.get(0).createActivity(name + counter, startAct, endAct);
			system.employees.get(0).myLeaderProjects.get(0).activities.get(counter).addEmployee(e2);
			system.employees.get(0).myLeaderProjects.get(0).activities.get(counter).addEmployee(e3);
		}

	}

	/**
	 * Tests the scenario that a leader wants to check the total number of hours
	 * spent on the entire project
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testTotalTimeSpentOnProject() throws InvalidInputException {

		// Check that total time spent on project is zero so far
		assertEquals(0, system.employees.get(0).myLeaderProjects.get(0).getTotalHours(),
				system.employees.get(0).myLeaderProjects.get(0).getTotalHours() - 0);

		// e2 and e3 register work hours to their first, second and third
		// activity
		int act1 = 1;
		int act2 = 2;
		int act3 = 3;

		// Check that the employees are affiliated with the selected activity
		assertTrue(system.employees.get(1).isAffiliated(act1));
		assertTrue(system.employees.get(1).isAffiliated(act2));
		assertTrue(system.employees.get(1).isAffiliated(act3));
		assertTrue(system.employees.get(2).isAffiliated(act1));
		assertTrue(system.employees.get(2).isAffiliated(act2));
		assertTrue(system.employees.get(2).isAffiliated(act3));

		// The given number of working hours for e2 and e3
		double hours1 = 5.5;
		double hours2 = 3.0;
		double hours3 = 6.5;
		double hours4 = 5;
		double hours5 = 0.5;

		// Register working hours in activity for their DaySchedules
		system.employees.get(1).registerHours(act1, hours1);
		system.employees.get(1).registerHours(act3, hours2);
		system.employees.get(2).registerHours(act1, hours3);
		system.employees.get(2).registerHours(act2, hours4);
		system.employees.get(1).registerHours(act3, hours5);

		// Check
		assertEquals(20.5, system.employees.get(0).myLeaderProjects.get(0).getTotalHours(),
				system.employees.get(0).myLeaderProjects.get(0).getTotalHours() - 20.5);

	}

	/**
	 * Tests the scenario that a leader wants to check the total number of hours
	 * spent on one activity in the project
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testTotalTimeSpentOnOneActivity() throws InvalidInputException {

		// Check that total time spent on activity is zero so far
		assertEquals(0, system.employees.get(0).myLeaderProjects.get(0).getActivityHours(2),
				system.employees.get(0).myLeaderProjects.get(0).getActivityHours(2) - 0);

		// e2 and e3 select activities 1, 2 and 3 in their WeekSchedules to register work hours on
		int act1 = 1;
		int act2 = 2;
		int act3 = 3;

		// Check that the employees are affiliated with the selected activity
		assertTrue(system.employees.get(1).isAffiliated(act1));
		assertTrue(system.employees.get(1).isAffiliated(act2));
		assertTrue(system.employees.get(1).isAffiliated(act3));
		assertTrue(system.employees.get(2).isAffiliated(act1));
		assertTrue(system.employees.get(2).isAffiliated(act2));
		assertTrue(system.employees.get(2).isAffiliated(act3));

		// The given number of working hours for e2 and e3
		double hours1 = 5.5;
		double hours2 = 3.0;
		double hours3 = 6.5;
		double hours4 = 5;
		double hours5 = 0.5;

		// Register working hours in activity for their DaySchedules
		system.employees.get(1).registerHours(act1, hours1);
		system.employees.get(1).registerHours(act3, hours2);
		system.employees.get(2).registerHours(act1, hours3);
		system.employees.get(2).registerHours(act2, hours4);
		system.employees.get(1).registerHours(act3, hours5);

		// Check
		assertEquals(12.0, system.employees.get(0).myLeaderProjects.get(0).getActivityHours(2),
				system.employees.get(0).myLeaderProjects.get(0).getActivityHours(2) - 12.0);

	}
	
	/**
	 * Tests the scenario that a leader wants to check the total number of hours
	 * spent on one activity in the project
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testTotalTimeExceedsBudgettedTime() throws InvalidInputException {

		system.employees.get(0).myLeaderProjects.get(0).setBudgettedTime(10);
		
		// Check that total time spent on project is zero so far
				assertEquals(0, system.employees.get(0).myLeaderProjects.get(0).getTotalHours(),
						system.employees.get(0).myLeaderProjects.get(0).getTotalHours() - 0);
		
		// e2 and e3 select activities 1, 2 and 3 in their WeekSchedules to register work hours on
		int act1 = 1;
		int act2 = 2;
		int act3 = 3;

		// Check that the employees are affiliated with the selected activity
		assertTrue(system.employees.get(1).isAffiliated(act1));
		assertTrue(system.employees.get(1).isAffiliated(act2));
		assertTrue(system.employees.get(1).isAffiliated(act3));
		assertTrue(system.employees.get(2).isAffiliated(act1));
		assertTrue(system.employees.get(2).isAffiliated(act2));
		assertTrue(system.employees.get(2).isAffiliated(act3));

		// The given number of working hours for e2 and e3
		double hours1 = 5.5;
		double hours2 = 3.0;
		double hours3 = 6.5;
		double hours4 = 5;
		double hours5 = 0.5;

		// Register working hours in activity for their DaySchedules
		system.employees.get(1).registerHours(act1, hours1);
		system.employees.get(1).registerHours(act3, hours2);
		system.employees.get(2).registerHours(act1, hours3);
		system.employees.get(2).registerHours(act2, hours4);
		system.employees.get(1).registerHours(act3, hours5);

		// Check that total time spent on project is zero so far
		assertEquals(20.5, system.employees.get(0).myLeaderProjects.get(0).getTotalHours(),
				system.employees.get(0).myLeaderProjects.get(0).getTotalHours() - 20.5);


	}
	
}

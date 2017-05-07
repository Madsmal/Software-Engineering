package project.app;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import project.app.InvalidInputException;
import project.app.MissingInputException;

/**
 * This class contains tests, testing the functionality of registering
 * external activities such as sickness, vacations etc.
 */

public class TestRegisterExternalActivity extends SampleDataSetup {

	/**
	 * Tests the scenario that the user wants to register
	 * sickness on January 23, 2016.
	 * @throws MissingInputException
	 * @throws InvalidInputException
	 */
	@Test
	public void testValidTypeAndDate() throws MissingInputException, InvalidInputException {

		// Activity type
		char type = 'S';
		
		// Date of sickness for e1
		Calendar startDate = new GregorianCalendar(2016, Calendar.MAY, 4);
		Calendar endDate = new GregorianCalendar(2016, Calendar.MAY, 4);
		
		system.employees.get(0).registerOtherActivity(type, startDate, endDate);
		
		assertTrue(system.employees.get(0).myWeeks[startDate.WEEK_OF_YEAR].hasOtherActivity());
		assertEquals('S',system.employees.get(0).myDays[startDate.DAY_OF_YEAR].getOtherActivity());

	}
}

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
 * This class contains tests, testing the functionality of appointing a leader to
 * a project
 */


public class TestSetLeader {

	SoftwareSystem System = new SoftwareSystem();
	Medarbejder eks1;
	Medarbejder eks2;
	Medarbejder eks3;
	
	
	@Before
	public void addEmployess() throws NoInputException, OperationNotAllowedException {
		eks1 = new Medarbejder("M.M",System);
		eks2 = new Medarbejder("O.I.P",System);
		eks3 = new Medarbejder("N.M",System);
		System.Medarbejder.add(eks1);
		System.Medarbejder.add(eks2);
		System.Medarbejder.add(eks3);
		
		eks1.OpretProject("A", "Y", "01-01-1006", null, System);
		eks1.OpretProject("Y", "A", "19-10-2016", null, System);

	}

	/**
	 * Tests the scenario that the user wants to set a project leader
	 * providing a valid set of initials.
	 */
	@Test
	public void testSetValidLeader() throws NoInputException {
		
		//Tests that the project has no leader
		assertEquals(false, System.Projekts.get(0).harLeder);
				
		// Set e2 as the leader of project "P1"
		System.Medarbejder.get(0).myProjects.get(0).setLeader(eks2);
		
		// Check that the project leader is updated
		assertEquals(eks2, System.Medarbejder.get(0).myProjects.get(0).getLeder());
		
	}

	/**
	 * Tests the scenario that the user wants to set a project leader
	 * providing an invalid set of initials.
	 */
	@Test
	public void testSetInvalidLeader() {
		try{
			// Set invalid employee, null, as the leader of project "P1"
			System.Medarbejder.get(0).myProjects.get(0).setLeader(null);
			fail("Should throw MissingInputException");
			}
			catch (NoInputException e) {
				assertEquals("Please set valid leader",e.getMessage());
				assertEquals("Set leader",e.getOperation());
				// Check that the project leader has not been updated
				assertFalse(System.Projekts.get(0).harLeder);
				
			}
		
	}
	
	/**
	 * Tests the scenario that the user wants to set a project leader
	 * providing an invalid set of initials.
	 * @throws MissingInputException 
	 */
	@Test
	public void testOverwriteLeader() throws NoInputException {
		// Set e2 as the leader of project "P1" 
			System.Medarbejder.get(0).myProjects.get(0).setLeader(eks2);
				
			try{
				// e1 tries to set e1 as the leader of project "P1"
				System.Medarbejder.get(0).myProjects.get(0).setLeader(eks1);
				fail("Should throw MissingInputException");
				}
				catch (NoInputException e) {
					assertEquals("The leader has already been set",e.getMessage());
					assertEquals("Set leader",e.getOperation());
					// Check that the project leader has not been updated
					assertTrue(System.Projekts.get(0).harLeder);
						
			}
				
	}
	
}

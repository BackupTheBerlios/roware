/*
 *  roware
 *
 *  See AUTHORS for copyright information.
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package de.berlios.roware.model;

import junit.framework.TestCase;
import de.berlios.roware.model.rule.BoatRule;
import de.berlios.roware.model.rule.LightweightRule;
import de.berlios.roware.model.rule.RuleViolationException;
import de.berlios.roware.model.rule.RulesManager;

/**
 * BoatTest
 * 
 * @author Tammo van Lessen
 * @version $id: $
 */
public class BoatTest extends TestCase {

	private Team doubleScullsTeam;

	/**
	 * Constructor for BoatTest.
	 * @param arg0
	 */
	public BoatTest(String arg0) {
		super(arg0);
	}

	public void testBoat() {
		Boat boat = new Boat(Boat.SINGLE_SCULLS);
		assertEquals(Boat.SINGLE_SCULLS, boat.getType());
		assertFalse(boat.isCoxed());

		boat = new Boat(Boat.DOUBLE_SCULLS);
		assertEquals(Boat.DOUBLE_SCULLS, boat.getType());
		assertFalse(boat.isCoxed());

		boat = new Boat(Boat.QUADRUPPLE_SCULLS);
		assertEquals(Boat.QUADRUPPLE_SCULLS, boat.getType());
		assertFalse(boat.isCoxed());

		boat = new Boat(Boat.PAIRS);
		assertEquals(Boat.PAIRS, boat.getType());
		assertFalse(boat.isCoxed());
		
		boat = new Boat(Boat.PAIRS_COXED);
		assertEquals(Boat.PAIRS_COXED, boat.getType());
		assertTrue(boat.isCoxed());

		boat = new Boat(Boat.FOURS);
		assertEquals(Boat.FOURS, boat.getType());
		assertFalse(boat.isCoxed());

		boat = new Boat(Boat.FOURS_COXED);
		assertEquals(Boat.FOURS_COXED, boat.getType());
		assertTrue(boat.isCoxed());

		boat = new Boat(Boat.QUADRUPPLE_SCULLS_COXED);
		assertEquals(Boat.QUADRUPPLE_SCULLS_COXED, boat.getType());
		assertTrue(boat.isCoxed());

		boat = new Boat(Boat.EIGHTS_COXED);
		assertEquals(Boat.EIGHTS_COXED, boat.getType());
		assertTrue(boat.isCoxed());
		
		boat = new Boat(Boat.OTHER);
		assertEquals(Boat.OTHER, boat.getType());
	}

	public void testGetType() {
		Boat boat = new Boat(Boat.DOUBLE_SCULLS);
		assertEquals(Boat.DOUBLE_SCULLS, boat.getType());
		assertFalse(boat.isCoxed());
	}

	public void testSetType() {
		Boat boat = new Boat(Boat.DOUBLE_SCULLS);
		boat.setType(Boat.PAIRS_COXED);
		assertEquals(Boat.PAIRS_COXED, boat.getType());
		assertTrue(boat.isCoxed());
	}

	public void testSetTeam() {
		Boat boat = new Boat(Boat.DOUBLE_SCULLS);
		Team team = new Team();
		boolean error = false;
		try {
			boat.setTeam(team);
		} catch (IncompatibleTeamException e) {
			error = true;
		}
		assertTrue(error);
		
		Athlete ath1 = new Athlete();
		ath1.setGender(Boat.MALE);
		Athlete ath2 = new Athlete();
		ath2.setGender(Boat.MALE);
		team.getAthletes().add(ath1);
		team.getAthletes().add(ath2);
		error = false;
		try {
			boat.setTeam(team);
		} catch (IncompatibleTeamException e) {
			error = true;
		}
		assertFalse(error);
		
		assertSame(team, boat.getTeam());
	}

	public void testIsVirtual() {
		Boat boat = new Boat(Boat.DOUBLE_SCULLS);
		assertTrue(boat.isVirtual());
		try {
			boat.setTeam(doubleScullsTeam);
		} catch (IncompatibleTeamException e) {
		}
		assertFalse(boat.isVirtual());

	}

	public void testGetCoxed() {
		Boat boat = new Boat(Boat.DOUBLE_SCULLS);
		assertFalse(boat.isCoxed());
		boat = new Boat(Boat.PAIRS_COXED);
		assertTrue(boat.isCoxed());
	}

	public void testSetCox() {
		Boat boat = new Boat(Boat.DOUBLE_SCULLS);
		assertNull(boat.getCox());
		Athlete ath = new Athlete();
		ath.setGender(Boat.MALE);
		boat.setCox(ath);
		assertSame(ath, boat.getCox());
	}

	public void testSetLightweight() {
		Boat boat = new Boat(Boat.DOUBLE_SCULLS);
		assertFalse(boat.isLightweight());
		boat.setLightweight(true);
		assertTrue(boat.isLightweight());
		boat.setLightweight(false);
		assertFalse(boat.isLightweight());
	}

	public void testValidate() {
		Boat boat = new Boat(Boat.DOUBLE_SCULLS);
		try {
			boat.setTeam(doubleScullsTeam);
		} catch (IncompatibleTeamException e2) {
			fail("incompatible team");
		}

		// Test RuleNotFound		
		boolean valid = true;
		try {
			boat.validate();
		} catch (RuleViolationException e) {
			valid = false;
		}
		assertFalse(valid);
		
		try {
			RulesManager.getInstance().registerRule("BoatRule", BoatRule.class);
			RulesManager.getInstance().registerRule("LightweightRule", LightweightRule.class);
		} catch (Exception e1) {
			fail("Rule registration failed");
		}

		// Test BoatRule		
		valid = true;
		try {
			boat.setGender(Boat.MALE);
			boat.validate();
		} catch (RuleViolationException e) {
			valid = false;
		}
		assertTrue(valid);

		// Test BoatRule and LightweightRule		
		valid = true;
		boat.setLightweight(true);
		try {
			boat.validate();
		} catch (RuleViolationException e) {
			valid = false;
		}
		assertTrue(valid);

	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		doubleScullsTeam = new Team();
		Athlete ath = new Athlete();
		ath.setGender(Boat.MALE);
		ath.setWeight(70);
		doubleScullsTeam.getAthletes().add(ath);
		doubleScullsTeam.getAthletes().add(ath);
	}

}

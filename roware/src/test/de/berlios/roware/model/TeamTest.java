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

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * @author jpraetorius
 * @
 */
public class TeamTest extends TestCase {
	
	private Athlete ath1;
	private Athlete ath2;
	private Athlete ath3;
	private Athlete ath4;
	private Athlete ath5;
	private Team team;
	
	/**
	 * Constructor for TeamTest.
	 * @param arg0
	 */
	public TeamTest(String arg0) {
		super(arg0);
	}
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		ath1 = new Athlete("John Doe");
		ath1.setWeight(70);
		ath1.setGender(Boat.MALE);
		
		ath2 = new Athlete("Foo Bar");
		ath2.setWeight(70);
		ath2.setGender(Boat.MALE);
		
		ath3 = new Athlete("Max Muster");
		ath3.setWeight(70);
		ath3.setGender(Boat.MALE);
		
		ath4 = new Athlete("Susi Sorglos");
		ath4.setWeight(70);
		ath4.setGender(Boat.FEMALE);
		
		ath5 = new Athlete("Rainer Zufall");
		ath5.setWeight(70);
		ath5.setGender(Boat.MALE);
		
		team = new Team();
		team.addAthlete(ath1);
		team.addAthlete(ath2);
		team.addAthlete(ath3);
		team.addAthlete(ath4);
		team.setId(1234);
	}
	
	public void testId() {
		assertEquals(1234,team.getId());
		team.setId(12345);
		assertEquals(12345,team.getId());
	}
	
	public void testGetAthlete() {
		assertEquals("John",((Athlete)team.getAthlete(0)).getFirstName());
	}
	
	public void testGetAthletes() {
		assertEquals(4,team.getAthletes().size());
	}
	
	public void testSetAthletes() {
		List l = new ArrayList();
		l.add(ath1);
		l.add(ath2);
		team.setAthletes(l);
		assertSame(l,team.getAthletes());
	}
	
	public void testAddAthlete() {
		team.addAthlete(ath5);
		assertEquals(5,team.getAthletes().size());
	}
	
	public void testGetAverageWeight() {
		assertEquals(70,team.getAverageWeight());
	}
	public void testGetGender() {
		List l1 = new ArrayList();
		List l2 = new ArrayList();
		
		l1.add(ath1);
		l1.add(ath2);
		l1.add(ath3);
		
		l2.add(ath4);
		
		assertEquals(Boat.MIXED,team.getGender());
		team.setAthletes(l1);
		assertEquals(Boat.MALE,team.getGender());
		team.setAthletes(l2);
		assertEquals(Boat.FEMALE,team.getGender());
	
	}
	public void testGetAge() {
		assertEquals(Boat.SENIOR_A,team.getAge());
	}
}

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

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

/**
 * @author jpraetorius
 */
public class AthleteTest extends TestCase {
	private Club club;
	private Athlete ath;
	private Address workAddress;
	private Address homeAddress1;
	private Address homeAddress2;
	
	
	/**
	 * Constructor for AthleteTest.
	 * @param arg0
	 */
	public AthleteTest(String arg0) {
		super(arg0);
	}
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		ath = new Athlete();
		ath.setBirthday(new GregorianCalendar(1990,0,1).getTime());
		ath.setFirstName("John");
		ath.setName("Doe");
		ath.setGender(Boat.MALE);
		ath.setId(12345);
		ath.setLicense(true);
		ath.setWeight(70);
		ath.setWeightDate(new GregorianCalendar(1990,0,1).getTime());
				
		workAddress = new Address("Street","12345","City",Address.TYPE_WORK,"+49 30 123 45 67",Address.PHONE_OFFICE,"john@doe.com",Address.EMAIL_OFFICE);
		homeAddress1 = new Address("Street","12345","City",Address.TYPE_PRIVATE,"+49 30 123 45 67",Address.PHONE_OFFICE,"john@doe.com",Address.EMAIL_OFFICE);
		homeAddress2 = new Address("Street","12345","City",Address.TYPE_PRIVATE,"+49 30 123 45 67",Address.PHONE_OFFICE,"john@doe.com",Address.EMAIL_OFFICE);
		club = new Club();
		club.setCity("Berlin");
		club.setName("Ruderklub am Wannsee");
		club.setShortName("RaW");	
		club.addAddress(workAddress);
		
		ath.addAddress(workAddress);
		ath.addAddress(homeAddress1);
		ath.addAddress(homeAddress2);
		ath.setClub(club);
	}
	public void testAthlete() {
		Athlete at = new Athlete("John Doe");
		assertEquals("John",at.getFirstName());
		assertEquals("Doe",at.getName());
		
		at = new Athlete();
		at.setFullName("John Doe");
		assertEquals("John",at.getFirstName());
		assertEquals("Doe",at.getName());
	
	}
	
	public void testWeight() {
		assertEquals(70,ath.getWeight());
		ath.setWeight(90);
		assertEquals(90,ath.getWeight());
	}
	
	public void testLicense() {
		assertTrue(ath.hasLicense());
		ath.setLicense(false);
		assertFalse(ath.hasLicense());
	}
	
	public void testWeightDate() {
		Date d = new GregorianCalendar(1990,0,2).getTime();
		assertEquals(new GregorianCalendar(1990,0,1).getTime(),ath.getWeightDate());
		ath.setWeightDate(d);
		assertEquals(d,ath.getWeightDate());
		//this should be true also
		assertSame(d,ath.getWeightDate());
	
	}
	
	public void testId() {
		assertEquals(12345,ath.getId());
		ath.setId(123456);
		assertEquals(123456,ath.getId());
	}
	
	public void testBirthday() {
		assertEquals(new GregorianCalendar(1990,0,1).getTime(),ath.getBirthday());
		Date d = new GregorianCalendar(1990,0,2).getTime();
		ath.setBirthday(d);
		assertEquals(d,ath.getBirthday());
		//this should be true also
		assertSame(d,ath.getBirthday());
	}
	
	public void testGender() {
		assertEquals(Boat.MALE,ath.getGender());
		ath.setGender(Boat.FEMALE);
		assertEquals(Boat.FEMALE,ath.getGender());
	}
	
	public void testGetAge() {
		//TODO This has to be updated every Year... :(
		assertEquals(Boat.CHILDREN_13,ath.getAge());
	}
	
	public void testFirstName() {
		assertEquals("John",ath.getFirstName());
		ath.setFirstName("Foo");
		assertEquals("Foo",ath.getFirstName());
	}
	
	public void testName() {
		assertEquals("Doe",ath.getName());
		ath.setName("Bar");
		assertEquals("Bar",ath.getName());
	}
	
	public void testSetFullName() {
		ath.setFullName("John Doe");
		assertEquals("John",ath.getFirstName());
		assertEquals("Doe",ath.getName());
	}
	
	public void testAddAddress() {
		Address a = new Address();
		ath.addAddress(a);
		assertEquals(4,ath.getAllAddresses().length);
	}
	public void testGetAllAddresses() {
		assertEquals(3,ath.getAllAddresses().length);
	}
	public void testGetAddressByType() {
		assertEquals(2,ath.getAddressByType(Address.TYPE_PRIVATE).size());
	}
	
	public void testClub(){
		assertEquals("RaW",ath.getClub().getShortName());
		Club c = new Club();
		ath.setClub(c);
		assertSame(c,ath.getClub());
	}
}

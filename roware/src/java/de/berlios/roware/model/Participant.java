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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Participant - Superclass for all Persons Participating in Competitions organzied with roware.
 * 
 * @author Tammo van Lessen
 * @version $Id: Participant.java,v 1.6 2003/10/30 16:18:48 jpraetorius Exp $
 * 
 * TODO: Add  hashcode()!
 */
public abstract class Participant extends AbstractPerson {

	private int gender = 0;
	private long id = 0;
	private Date birthday = null;
	private Club club = null;
	
	/**
	 * Constructor
	 */
	public Participant() {
		super();
	}
	
	public Participant(String name){
		super(name);
	}
	
	
	/**
	 * Constructor
	 * @param gender the Gender of the Person, as defined in Person
	 * @param name The Full Name of the Person
	 */
	public Participant(int gender, String name){
		super(name);
		this.gender = gender;
		
	}
	
	/**
	 * Constructor
	 */
	public Participant(String name, String firstName, int gender){
		super(name, firstName);
		this.gender = gender;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setBirthday(Date date){
		birthday = date;
	}

	public Date getBirthday(){
		return birthday;
	}

	/**
	 * @return the Gender of the Person.
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * @param i may be one of the Constants defined in this Class.
	 */
	public void setGender(int i) {
		gender = i;
	}
	
	/** 
	 * Checked herein are Name and Birthday. 
	 * @return true if the two Objects are the Same false otherwise.
	 * @see java.lang.Object#equals(java.lang.Object)
	*/
	public boolean equals(Object arg0) {
		if (arg0 instanceof Participant){
			Participant other = (Participant) arg0;
			return ( (other.getName().equals(this.getName())) && (other.getFirstName().equals(this.getFirstName())) && (other.getBirthday().equals(this.birthday)));
		}
		else {
			return false;
		}
	}//equals
	
	
	/**
	 * Computes the AgeClass of the Athlete
	 * @return the correspondend AgeClass as defined in here
	 */
	public int getAge(){
		Calendar c = new GregorianCalendar();
		int thisYear = c.get(Calendar.YEAR);
		c.setTime(birthday);
		int athleteYear = c.get(Calendar.YEAR);
		int difference = thisYear - athleteYear;
		switch(difference){
			case 10: return Boat.CHILDREN_11; 
			case 11: return Boat.CHILDREN_11; 
			case 12: return Boat.CHILDREN_12; 
			case 13: return Boat.CHILDREN_13; 
			case 14: return Boat.CHILDREN_14; 
			case 15: return Boat.JUNIOR_B; 
			case 16: return Boat.JUNIOR_B; 
			case 17: return Boat.JUNIOR_A; 
			case 19: return Boat.JUNIOR_A; 
			case 20: return Boat.SENIOR_B;
			case 21: return Boat.SENIOR_B;
			case 22: return Boat.SENIOR_B;
			//TODO: This is not really right...
			default: return Boat.SENIOR_A;
		}		
	}
	
	public void setClub (Club c){
		club = c;
	}
	
	public Club getClub(){
		return club;
	}
}

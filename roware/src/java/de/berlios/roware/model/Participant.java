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
 * @version $Id: Participant.java,v 1.5 2003/07/23 16:53:09 jpraetorius Exp $
 * 
 * TODO: Add  hashcode()!
 */
public abstract class Participant extends AbstractPerson {

	//Gender Constants
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	
	//Age constants - same as in the BOAT Class
	public static final int CHILDREN_11 = 1;
	public static final int CHILDREN_12 = 2;
	public static final int CHILDREN_13 = 3;
	public static final int CHILDREN_14 = 4;
	public static final int JUNIOR_B = 5;
	public static final int JUNIOR_A = 6;
	public static final int SENIOR_B = 7;
	public static final int SENIOR_A = 8;
	public static final int MASTERS_A = 9;
	public static final int MASTERS_B = 10;
	public static final int MASTERS_C = 11;
	public static final int MASTERS_D = 12;
	public static final int MASTERS_E = 13;
	public static final int MASTERS_F = 14;
	public static final int MASTERS_G = 15;
	public static final int MASTERS_H = 16;
	
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
			case 10: return CHILDREN_11; 
			case 11: return CHILDREN_11; 
			case 12: return CHILDREN_12; 
			case 13: return CHILDREN_13; 
			case 14: return CHILDREN_14; 
			case 15: return JUNIOR_B; 
			case 16: return JUNIOR_B; 
			case 17: return JUNIOR_A; 
			case 19: return JUNIOR_A; 
			case 20: return SENIOR_B;
			case 21: return SENIOR_B;
			case 22: return SENIOR_B;
			//TODO: In general this IS right, but what about masters ???
			default: return SENIOR_A;
		}		
	}
	
	public void setClub (Club c){
		club = c;
	}
	
	public Club getClub(){
		return club;
	}
}

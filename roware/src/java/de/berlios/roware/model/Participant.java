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

/**
 * Participant
 * 
 * @author Tammo van Lessen
 * @version $Id: Participant.java,v 1.3 2003/07/10 22:29:34 vanto Exp $
 * 
 * TODO: Add equals() and hashcode()!!!!!!!!!
 */
public abstract class Participant extends AbstractPerson {

	public static final int MALE = 1;
	public static final int FEMALE = 2;
	
	private int gender;
	private String name;
	private long id;
	private boolean coach = false;
	
	/**
	 * TODO Participant
	 */
	public Participant() {
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	/**
	 * @return
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * @param i
	 */
	public void setGender(int i) {
		gender = i;
	}

	/**
	 * @return
	 */
	public boolean isCoach() {
		return coach;
	}

	/**
	 * @param b
	 */
	public void setCoach(boolean b) {
		coach = b;
	}

}

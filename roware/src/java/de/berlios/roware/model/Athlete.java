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

/**
 * Athlete
 * 
 * @author Tammo van Lessen
 * @version $Id: Athlete.java,v 1.5 2003/07/15 16:02:40 jpraetorius Exp $
 */
public class Athlete extends Participant {

	private int weight;
	private Date weightDate;
	private boolean license;

	/**
	 * TODO Athlete Constructors
	 */
	public Athlete() {
		
	}
	
	/**
	 * sets weight in gramm
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * @return the weight of the Athlete in gramms
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Sets whether this Athlete has a valid License
	 * @param b the Value to set
	 */
	public void setLicense(boolean b){
		license = b;
	}
	
	/**
	 * returns whether this Athlete has a valid License
	 * @return true if so, false otherwise
	 */
	public boolean hasLicense(){
		return license;
	}
	
	/**
	 * The Date the given weight is from
	 * @param d the Date
	 */
	public void setWeightDate(Date d){
		weightDate = d;
	}
	
	/**
	 * Returns the Date at which the given weight was weighed.
	 * @return the Date
	 */
	public Date getWeightDate(){
		return weightDate;
	}
}

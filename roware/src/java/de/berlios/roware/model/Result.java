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
import java.util.Date;
import java.util.List;

/**
 * Result.java
 * This holds the Results for a Run a Boat has done.
 * @author Joachim Praetorius
 */
public class Result {

	private int position = 0;
	private Date date = null;
	private Boat boat = null;
	private List timestamps = new ArrayList();

	public Result(int position){
		this.position = position;
		date = new Date();
	}
	
	public Result(Boat b){
		this.boat = b;
		date = new Date();
	}

	public Result(int position, Boat b){
		this.position = position;
		this.boat = b;
		date = new Date();
	}
	
	
	/**
	 * Adds a Timestamp to the List
	 * @param d - The timestamp to tkae
	 * @param description - The description <b>where</b> this timestamp was
	 * taken (e.g. '1000m')
	 */
	public void addTimestamp(Date d,String description){
		timestamps.add(d);
		timestamps.add(description);
	}	

	/**
	 * Returns the boat.
	 * @return Boat
	 */
	public Boat getBoat() {
		return boat;
	}

	/**
	 * Returns the date.
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Returns the position.
	 * @return int
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Returns the timestamps.
	 * @return List
	 */
	public List getTimestamps() {
		return timestamps;
	}

	/**
	 * Sets the boat.
	 * @param boat The boat to set
	 */
	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	/**
	 * Sets the date.
	 * @param date The date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Sets the position.
	 * @param position The position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

}

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
 * Event.java
 * This is a model for Events that are held during thew course of a Regatta. The
 * special thing about these things is that they all may be held at different
 * locations and are supervised by different people so they each get their own
 * Location and Person members.
 * 
 * @author Joachim Praetorius
 */
public class Event {

	private String title = null;
	private Address location = null;
 	private AbstractPerson chair = null;
 	private Date date = null;
 	
 	public Event(){
 	}
 	
 	public Event(String title){
 		this.title = title;
 	}
 	
 	public Event(Date d){
 		date = d;
 	}
 	
 	public Event(String title, Date d){
 		this.title = title;
 		this.date = d;
 	}
	
	
	/**
	 * Returns the chair.
	 * @return AbstractPerson
	 */
	public AbstractPerson getChair() {
		return chair;
	}

	/**
	 * Returns the date.
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Returns the location.
	 * @return Address
	 */
	public Address getLocation() {
		return location;
	}

	/**
	 * Returns the title.
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the chair.
	 * @param chair The chair to set
	 */
	public void setChair(AbstractPerson chair) {
		this.chair = chair;
	}

	/**
	 * Sets the date.
	 * @param date The date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Sets the location.
	 * @param location The location to set
	 */
	public void setLocation(Address location) {
		this.location = location;
	}

	/**
	 * Sets the title.
	 * @param title The title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}

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
import java.util.Date;

/**
 * Regatta.java
 * This models a single Regatta and is simply 
 * a Container Object for holding all the related Data needed for running a
 * Regatta
 * 
 * @author Joachim Praetorius
 */
public class Regatta {

	private String name = null;
	private Club host = null;
	private List remarks = new ArrayList();
	private List races = new ArrayList();
	private Date fromDate = null;
	private Date toDate = null;
	private Event raffle = null;
	private Event dueDate = null;

	public Regatta(){
	}
	
	public Regatta(String name){
		this.name = name;
	}

	public Regatta(String name,Club host){
		this.name = name;
		this.host= host;
	}
	
	public Regatta(String name,Date fromDate, Date toDate){
		this.name = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public Regatta(String name, Club host, Date fromDate, Date toDate){
		this.name = name;
		this.host = host;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public void addRace(Race r){
		races.add(r);
	}
	
	public void addRemark(Remark r){
		remarks.add(r);
	}
	
	/**
	 * Returns the dueDate.
	 * @return Event
	 */
	public Event getDueDate() {
		return dueDate;
	}

	/**
	 * Returns the fromDate.
	 * @return Date
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * Returns the host.
	 * @return Club
	 */
	public Club getHost() {
		return host;
	}

	/**
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the races.
	 * @return List
	 */
	public List getRaces() {
		return races;
	}

	/**
	 * Returns the raffle.
	 * @return Event
	 */
	public Event getRaffle() {
		return raffle;
	}

	/**
	 * Returns the remarks.
	 * @return List
	 */
	public List getRemarks() {
		return remarks;
	}

	/**
	 * Returns the toDate.
	 * @return Date
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * Sets the dueDate.
	 * @param dueDate The dueDate to set
	 */
	public void setDueDate(Event dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Sets the fromDate.
	 * @param fromDate The fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Sets the host.
	 * @param host The host to set
	 */
	public void setHost(Club host) {
		this.host = host;
	}

	/**
	 * Sets the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the races.
	 * @param races The races to set
	 */
	public void setRaces(List races) {
		this.races = races;
	}

	/**
	 * Sets the raffle.
	 * @param raffle The raffle to set
	 */
	public void setRaffle(Event raffle) {
		this.raffle = raffle;
	}

	/**
	 * Sets the remarks.
	 * @param remarks The remarks to set
	 */
	public void setRemarks(List remarks) {
		this.remarks = remarks;
	}

	/**
	 * Sets the toDate.
	 * @param toDate The toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}

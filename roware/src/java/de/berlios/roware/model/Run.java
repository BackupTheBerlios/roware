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
 * Run.java
 * This models a single run - two to six boats competing with each other.
 * 
 * @author Joachim Praetorius
 */
public class Run {

	public static final int STATUS_NOTSTARTED = 1;
	public static final int STATUS_STARTED = 2;
	public static final int STATUS_FINISHED = 3;
	public static final int STATUS_ABORTED = 4;
	public static final int STATUS_DEFERRED = 5;

	public static final int TYPE_HEAT = 1;
	public static final int TYPE_REPECHAGE = 2;
	public static final int TYPE_SEMIFINAL = 3;
	public static final int TYPE_FINAL_A = 4;
	public static final int TYPE_FINAL_B = 5;

	private int status = STATUS_NOTSTARTED;
	private int type = 0;
	private Date scheduledTime = null;
	private Date startTime = null;
	private List boats = new ArrayList();
	private List results = new ArrayList();

	public Run() {}

	public Run(List boats) {
		this.boats = boats;
	}

	public Run(Date scheduleTime) {
		this.scheduledTime = scheduleTime;
	}

	public Run(List boats, Date scheduleTime) {
		this.boats = boats;
		this.scheduledTime = scheduleTime;
	}

	public Run(int type) {
		this.type = type;
	}

	public Run(List boats, int type) {
		this.boats = boats;
		this.type = type;
	}

	public Run(Date scheduleTime, int type) {
		this.scheduledTime = scheduleTime;
		this.type = type;
	}

	public Run(List boats, Date scheduleTime, int type) {
		this.boats = boats;
		this.scheduledTime = scheduleTime;
		this.type = type;
	}

	public void start(){
		startTime = new Date();
	}

	public void addResult(Result r){
		results.add(r);
	}
	
	public void addBoat(Boat b){
		boats.add(b);
	}

	/**
	 * Returns the boats.
	 * @return List
	 */
	public List getBoats() {
		return boats;
	}

	/**
	 * Returns the results.
	 * @return List
	 */
	public List getResults() {
		return results;
	}

	/**
	 * Returns the scheduledTime.
	 * @return Date
	 */
	public Date getScheduledTime() {
		return scheduledTime;
	}

	/**
	 * Returns the startTime.
	 * @return Date
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Returns the status.
	 * @return int
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Returns the type.
	 * @return int
	 */
	public int getType() {
		return type;
	}

	/**
	 * Sets the boats.
	 * @param boats The boats to set
	 */
	public void setBoats(List boats) {
		this.boats = boats;
	}

	/**
	 * Sets the results.
	 * @param results The results to set
	 */
	public void setResults(List results) {
		this.results = results;
	}

	/**
	 * Sets the scheduledTime.
	 * @param scheduledTime The scheduledTime to set
	 */
	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	/**
	 * Sets the startTime.
	 * @param startTime The startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Sets the status.
	 * @param status The status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Sets the type.
	 * @param type The type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

}

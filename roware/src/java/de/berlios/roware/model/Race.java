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

/**
 * Race.java
 * This is a Race. It holds the Specification of all details about the Race and
 * also includes (later) the Boats signed in for that Race.
 * 
 * The Race class os smart enough to split the Boats in Sections by itself, so
 * that these Sections are in accordance with the Rules of the DRV. 
 * 
 * @author Joachim Praetorius
 */
public class Race {

	private String raceNo = null;
	private int gender = 0;
	private boolean lightweight = false;
	private boolean gigBoat = false;
	private boolean skulls = false;
	private boolean coxed = false;
	private int seatCount = 0;
	private List ageClasses = new ArrayList();
	private List competitionClasses = new ArrayList();
	private List sections = new ArrayList();
	private List boats = new ArrayList();
	
	public Race(){
	}
	
	public Race(String number){
		this.raceNo = number;
	}
	
	public Race(String number,int gender, boolean lightweight,boolean gig, boolean skulled, boolean coxed, int seatCount){
		this.raceNo = number;
		this.gender = gender;
		this.lightweight = lightweight;
		this.gigBoat = gig;
		this.skulls = skulled;
		this.coxed = coxed;
		this.seatCount = seatCount;
	}
	
	public void addBoat(Boat b){
		boats.add(b);
	}

	public List getSections(){
		computeSections();
		return sections;
	}
	
	private void computeSections(){
		//TODO: There has to be some logic in here. Right now it just gives back 
		//the complete List of Boats registered for this Race
		sections = boats;
	}

	/**
	 * Returns the ageClasses.
	 * @return List
	 */
	public List getAgeClasses() {
		return ageClasses;
	}

	/**
	 * Returns the boats.
	 * @return List
	 */
	public List getBoats() {
		return boats;
	}

	/**
	 * Returns the competitionClasses.
	 * @return List
	 */
	public List getCompetitionClasses() {
		return competitionClasses;
	}

	/**
	 * Returns the coxed.
	 * @return boolean
	 */
	public boolean isCoxed() {
		return coxed;
	}

	/**
	 * Returns the gender.
	 * @return int
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * Returns the gigBoat.
	 * @return boolean
	 */
	public boolean isGigBoat() {
		return gigBoat;
	}

	/**
	 * Returns the lightweight.
	 * @return boolean
	 */
	public boolean isLightweight() {
		return lightweight;
	}

	/**
	 * Returns the raceNo.
	 * @return String
	 */
	public String getRaceNo() {
		return raceNo;
	}

	/**
	 * Returns the seatCount.
	 * @return int
	 */
	public int getSeatCount() {
		return seatCount;
	}

	/**
	 * Returns the skulls.
	 * @return boolean
	 */
	public boolean isSkulls() {
		return skulls;
	}

	/**
	 * Sets the ageClasses.
	 * @param ageClasses The ageClasses to set
	 */
	public void setAgeClasses(List ageClasses) {
		this.ageClasses = ageClasses;
	}

	/**
	 * Sets the competitionClasses.
	 * @param competitionClasses The competitionClasses to set
	 */
	public void setCompetitionClasses(List competitionClasses) {
		this.competitionClasses = competitionClasses;
	}

	/**
	 * Sets the coxed.
	 * @param coxed The coxed to set
	 */
	public void setCoxed(boolean coxed) {
		this.coxed = coxed;
	}

	/**
	 * Sets the gender.
	 * @param gender The gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * Sets the gigBoat.
	 * @param gigBoat The gigBoat to set
	 */
	public void setGigBoat(boolean gigBoat) {
		this.gigBoat = gigBoat;
	}

	/**
	 * Sets the lightweight.
	 * @param lightweight The lightweight to set
	 */
	public void setLightweight(boolean lightweight) {
		this.lightweight = lightweight;
	}

	/**
	 * Sets the raceNo.
	 * @param raceNo The raceNo to set
	 */
	public void setRaceNo(String raceNo) {
		this.raceNo = raceNo;
	}

	/**
	 * Sets the seatCount.
	 * @param seatCount The seatCount to set
	 */
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	/**
	 * Sets the skulls.
	 * @param skulls The skulls to set
	 */
	public void setSkulls(boolean skulls) {
		this.skulls = skulls;
	}

}

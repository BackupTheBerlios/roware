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
 * Section.java
 * This is the Part of a Race. According to their competition and age Classes
 * the Boats are split into Sections, also according to the Rukes of DRV.
 * 
 * These Sections are themselves split into a number of runs - which have to
 * adhere to some rules again. So again the Sections class contains the
 * intelligence to split up it's boats into runs according to the Rules;
 *  
 * @author Joachim Praetorius
 */
public class Section {

	private List runs = new ArrayList();
	private List boats = new ArrayList();
	private int age = 0;
	private int competitionClass = 0;

	public Section(){
	}
	
	public Section(List boats){
		this.boats = boats;
	}
	
	public Section(List boats, int ageClass, int competitionClass){
		this.boats = boats;
		this.age = ageClass;
		this.competitionClass = competitionClass;
	}

	/*
	 * This is for use with the Web-Application. As long as there are more runs
	 * this Method will return true, so the Web-App may redisplay the new Runs
	 * and switch to the next Section only wwhen there are _no_ more new Runs
	 */
	public boolean hasMoreRuns(){
		computeRuns();
		return (runs.size() > 0);		
	}

	/**
	 * Return the next Run in this Section.
	 * The Run then is removed from the List of runs.
	 * @return Run the next run 
	 */
	public Run getNextRun(){
		Run r = (Run) runs.get(0);
		runs.remove(0);
		return r;
	}

	private void computeRuns(){
		//TODO: Here the Magic has to happen... :)
	}
	
	/**
	 * Returns the age.
	 * @return int
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Returns the boats.
	 * @return List
	 */
	public List getBoats() {
		return boats;
	}

	/**
	 * Returns the competitionClass.
	 * @return int
	 */
	public int getCompetitionClass() {
		return competitionClass;
	}

	/**
	 * Returns the runs.
	 * @return List
	 */
	public List getRuns() {
		return runs;
	}

	/**
	 * Sets the age.
	 * @param age The age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Sets the boats.
	 * @param boats The boats to set
	 */
	public void setBoats(List boats) {
		this.boats = boats;
	}

	/**
	 * Sets the competitionClass.
	 * @param competitionClass The competitionClass to set
	 */
	public void setCompetitionClass(int competitionClass) {
		this.competitionClass = competitionClass;
	}

}

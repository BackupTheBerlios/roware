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
 */package de.berlios.roware.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Team
 * 
 * @author Tammo van Lessen
 * @version $Id: Team.java,v 1.8 2003/07/23 16:53:09 jpraetorius Exp $
 * 
 * TODO: Add equals() and hashcode()!!!!!!!!! 
 */
public class Team {

	private long id;
	private List athletes = new ArrayList();
 
	/**
	 * TODO Team
	 */
	public Team() {
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public Athlete getAthlete(int index) {
		return (Athlete)athletes.get(index);
	}
	
	public List getAthletes() {
		return athletes;
		//return (Athlete[])athletes.toArray(new Athlete[0]);
	}

	public void setAthletes(List aths) {
		athletes = aths;
	}
	
	public void addAthlete(Athlete a){
		athletes.add(a);
	}

	/**
	 * returns the average weight. 0 means unkown.
	 * @return
	 */
	public int getAverageWeight() {
		Object[] aths = athletes.toArray();
		int sum = 0;
		for (int i = 0; i < aths.length; i++) {
			if (((Athlete)aths[i]).getWeight() == 0) {
				return 0;
			}
			sum += ((Athlete)aths[i]).getWeight();
		}
		return Math.round(sum / aths.length);
	}
	
	public int getGender(){
		Object[] aths = athletes.toArray();
		int sum = 0;
		for (int i=0;i<aths.length;i++){
			sum += ((Athlete)aths[i]).getGender();
		}
		int value = sum/aths.length;
		sum = sum%aths.length;		
		if(sum == 0){
			//This is one or two for pure Boats resulting in the right gender
			return value;
		}else{
			//in any other Case the Boat is mixed
			return Boat.MIXED;	
		}
	}
	
	public int getAge(){
		//TODO Implement this right
		return Boat.SENIOR_A;
	}
}

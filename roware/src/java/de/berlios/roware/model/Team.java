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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * Team
 * 
 * @author Tammo van Lessen
 * @version $Id: Team.java,v 1.9 2003/10/30 16:18:48 jpraetorius Exp $
 * 
 */
public class Team {

	private long id;
	private List athletes = new ArrayList();

	/**
	 * TODO Team
	 */
	public Team() {}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Athlete getAthlete(int index) {
		return (Athlete) athletes.get(index);
	}

	public List getAthletes() {
		return athletes;
		//return (Athlete[])athletes.toArray(new Athlete[0]);
	}

	public void setAthletes(List aths) {
		athletes = aths;
	}

	public void addAthlete(Athlete a) {
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
			if (((Athlete) aths[i]).getWeight() == 0) {
				return 0;
			}
			sum += ((Athlete) aths[i]).getWeight();
		}
		return Math.round(sum / aths.length);
	}

	public int getGender() {
		Object[] aths = athletes.toArray();
		int sum = 0;
		for (int i = 0; i < aths.length; i++) {
			sum += ((Athlete) aths[i]).getGender();
		}
		int value = sum / aths.length;
		sum = sum % aths.length;
		if (sum == 0) {
			//This is one or two for pure Boats resulting in the right gender
			return value;
		} else {
			//in any other Case the Boat is mixed
			return Boat.MIXED;
		}
	}

	public int getAge() {
		
		Calendar c = new GregorianCalendar();
		int sumAge = 0;
		int thisYear = c.get(Calendar.YEAR);
		int athleteYear;
		Athlete a;
		Iterator it = athletes.iterator();
		while(it.hasNext()){
			a = (Athlete) it.next();
			c.setTime(a.getBirthday());
			athleteYear = c.get(Calendar.YEAR);
			int difference = thisYear - athleteYear;
			sumAge +=difference;	
		}
		sumAge = sumAge / athletes.size();
		
		if (sumAge >= 10 && sumAge < 12){
			return Boat.CHILDREN_11;
		}else if(sumAge == 12){
			return Boat.CHILDREN_12;
		}else if(sumAge == 13){
			return Boat.CHILDREN_13;
		}else if(sumAge == 14){
			return Boat.CHILDREN_14;
		}else if(sumAge >=15 && sumAge < 17){
			return Boat.JUNIOR_B;
		}else if(sumAge >=17 && sumAge< 19){
			return Boat.JUNIOR_A;
		}else if(sumAge >= 19 && sumAge < 23){
			return Boat.SENIOR_B;
		}else if(sumAge >= 23 && sumAge < 27){
			return Boat.SENIOR_A;
		}else if(sumAge >= 27 && sumAge <36){
			return Boat.MASTERS_A;
		}else if(sumAge >=36 && sumAge < 43){
			return Boat.MASTERS_B;
		}else if(sumAge >=43 && sumAge < 50){
			return Boat.MASTERS_C;
		}else if(sumAge >=50 && sumAge < 55){
			return Boat.MASTERS_D;
		}else if(sumAge >=55 && sumAge < 60){
			return Boat.MASTERS_E;
		}else if(sumAge >=60 && sumAge < 65){
			return Boat.MASTERS_F;
		}else if(sumAge >=65 && sumAge <70){
			return Boat.MASTERS_G;
		}else if(sumAge>= 70){
			return Boat.MASTERS_H;
		}else{
			return Boat.UNKNOWN;
		}
		
		
		
	}

	/**
	 * TODO: At the Moment this also is coupled to the Order of the Atheletes
	 * within the Team. MAybe this could be done better?
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Team) {
			Team other = (Team) obj;
			List at = other.getAthletes();
			if (athletes.size() != at.size()) {
				//this cannot be
				return false;
			} else {
				for (int i = 0; i < at.size(); i++) {
					Athlete a1 = (Athlete) athletes.get(i);
					Athlete a2 = (Athlete) at.get(i);
					if (!a1.equals(a2)) {
						return false;
					} //if
				} //for
				return true;
			} //else

		} else {
			return false;
		}
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		Iterator it = athletes.iterator();
		Athlete a;
		StringBuffer s = new StringBuffer();
		while(it.hasNext()){
			a = (Athlete)it.next();
			s.append(a.getFirstName());
			s.append(a.getName());
		}//while
		return s.toString().hashCode();
	}

	
}//class

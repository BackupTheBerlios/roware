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
 * Competition.java
 * This is the Main Object for Managing Regattas. A Competition can contain a
 * number of Regatta Objects, as it is possible that there is more than one
 * Regatta at once in the same place
 * 
 * @author Joachim Praetorius
 */
public class Competition {

	private List regattas;
	private String place;
	
	public Competition(){
		regattas = new ArrayList();
		place = null;
	}

	public Competition(String place){
		regattas = new ArrayList();
		this.place = place;
	}
	
	public Competition(Regatta regatta,String place){
		regattas = new ArrayList();
		regattas.add(regatta);
		this.place = place;
	}
	
	public Competition(List regattas, String place){
		this.regattas = regattas;
		this.place = place;
	}
	
	
	/**
	 * Returns the place.
	 * @return String
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Returns the regattas.
	 * @return List
	 */
	public List getRegattas() {
		return regattas;
	}

	/**
	 * Sets the place.
	 * @param place The place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	public void addRegatta(Regatta r){
		regattas.add(r);
	}

}

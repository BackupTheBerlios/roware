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
 * @version $id: $
 */
public class Team {

	private List athletes = new ArrayList();

	/**
	 * TODO Team
	 */
	public Team() {
	}
	
	public void addAthlete(Athlete ath) {
		athletes.add(ath);
	}
	
	public Athlete[] getAthletes() {
		return (Athlete[])athletes.toArray(new Athlete[0]);
	}

	
	public void removeAthlete(Athlete ath) {
		athletes.remove(ath);
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
}

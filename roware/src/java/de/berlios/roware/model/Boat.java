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
import java.util.LinkedList;
import java.util.List;

import de.berlios.roware.model.rule.Checkable;
import de.berlios.roware.model.rule.RuleNotFoundException;
import de.berlios.roware.model.rule.RuleViolationException;
import de.berlios.roware.model.rule.RulesManager;

/**
 * Boat
 * 
 * @author Tammo van Lessen
 * @version $id: $
 */
public class Boat implements Checkable {
	
	private boolean coxed;
	private Team team;
	public static final int SINGLE_SCULLS = 1;
	public static final int DOUBLE_SCULLS = 2;
	public static final int QUADRUPPLE_SCULLS = 3;
	public static final int QUADRUPPLE_SCULLS_COXED = 4;
	public static final int PAIRS = 5;
	public static final int PAIRS_COXED = 6;
	public static final int FOURS = 7;
	public static final int FOURS_COXED = 8;
	public static final int EIGHTS_COXED = 9;	
	public static final int OTHER = 0;
	
	// TODO Implement this!!
	public static final int JUNIOR_B = 1;
	public static final int JUNIOR_A = 2;
	public static final int SENIOR_B = 3;
	public static final int SENIOR_A = 4;
	
	// TODO Implement this!!
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	public static final int MIXED = 3;
	
	private List athletes = new LinkedList();
	private List ruleViolations = new ArrayList();
	private Athlete cox = null;
	private boolean lightweight = false;
	private int type = 0;
	private int seats = 0; 
	
	/**
	 * TODO Boat 
	 */
	public Boat(int type) {
		setType(type);
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
		switch (type) {
			case SINGLE_SCULLS: 
				seats = 1;
				coxed = false;
				break;
			case DOUBLE_SCULLS:
				seats = 2;
				coxed = false;
				break;
			case QUADRUPPLE_SCULLS:
				seats = 4;
				coxed = false;
				break;
			case QUADRUPPLE_SCULLS_COXED:
				seats = 4;
				coxed = true;
				break;
			case PAIRS:
				seats = 2;
				coxed = false;
				break;
			case PAIRS_COXED:
				seats = 2;
				coxed = true;
				break;
			case FOURS:
				seats = 4;
				coxed = false;
				break;
			case FOURS_COXED:
				seats = 4;
				coxed = true;
				break;
			case EIGHTS_COXED:
				seats = 8;
				coxed = true;
				break;
			default: //case OTHER:
				seats = -1;
				coxed = false;
				break;
		}
	}
	
	public void setTeam(Team team) throws IncompatibleTeamException {
		if (team.getAthletes().length != seats) {
			throw new IncompatibleTeamException(this, team);
		}
		this.team = team;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public boolean isVirtual() {
		return (team == null);
	}
	
	public boolean isCoxed() {
		return coxed;
	}

	public void setCox(Athlete cox) {
		this.cox = cox;
	}
	
	public Athlete getCox() {
		return cox;
	}
	
	public void setLightweight(boolean lgw) {
		this.lightweight = lgw;
	}

	public boolean isLightweight() {
		return lightweight;
	}

	/**
	 * @see de.berlios.roware.model.rule.Checkable#isValid()
	 */
	public void validate() throws RuleViolationException {
		try {
			RulesManager.getInstance().check(this, "BoatRule");
			if (isLightweight()) {
				RulesManager.getInstance().check(this, "LightweightRule");

			}
		} catch (RuleNotFoundException e) {
			System.out.println(e.getMessage());
			throw new RuleViolationException(e);
		}
	}

}

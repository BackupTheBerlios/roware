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

import de.berlios.roware.model.Athlete;
import de.berlios.roware.model.rule.Checkable;
import de.berlios.roware.model.rule.RuleReport;
import de.berlios.roware.model.rule.RulesManager;

/**
 * Boat
 * 
 * @author <a href="mailto:vanto@users.berlios.de">Tammo van Lessen</a>
 * @version $id$
 */
public class Boat implements Checkable {
	
	public static final int SINGLE_SCULLS = 1;
	public static final int DOUBLE_SCULLS = 2;
	public static final int QUADRUPPLE_SCULLS = 3;
	public static final int PAIRS = 4;
	public static final int FOURS = 5;
	public static final int EIGHTS = 6;	
	
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
	
	/**
	 * TODO Boat 
	 */
	public Boat(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public void addAthlete(Athlete ath) {
		athletes.add(ath);
	}
	
	public Athlete[] getAthletes() {
		return (Athlete[])athletes.toArray();
	}

	public boolean isCoxed() {
		return (cox != null);
	}
	
	public void removeAthlete(Athlete ath) {
		athletes.remove(ath);
	}
	
	public void setCox(Athlete cox) {
		this.cox = cox;
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
	public boolean isValid() {
		return RulesManager.getInstance().check(this);
	}

	/**
	 * @see de.berlios.roware.model.rule.Checkable#addRuleReport(de.berlios.roware.model.rule.RuleReport)
	 */
	public void addRuleViolation(RuleReport report) {
		ruleViolations.add(report);
	}

}

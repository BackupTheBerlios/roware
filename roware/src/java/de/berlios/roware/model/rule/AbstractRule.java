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
package de.berlios.roware.model.rule;

/**
 * AbstractRule
 * 
 * @author <a href="mailto:vanto@users.berlios.de">Tammo van Lessen</a>
 * @version $id$
 */
public abstract class AbstractRule {

	/**
	 * TODO AbstractRule
	 */
	public AbstractRule() {
	}
	
	/**
	 * returns true, if rule can applied to the testee
	 * 
	 * @param obj
	 * @return
	 */
	public boolean canCheck(Checkable obj) {
		Class[] tc = getCheckableClasses();
		for (int i = 0; i < tc.length; i++) {
			if (tc[i].isInstance(obj)) return true;
		}
		return false;
	}
	
	public abstract Class[] getCheckableClasses();
	
	/** 
	 * returns true if object is successfully validated by 
	 * this rule.
	 * 
	 * found problems should be reported by 
	 * <code>addRuleViolation(String report)</code>
	 */
	public abstract void check(Checkable obj) throws RuleViolationException;

}

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

import java.util.HashSet;
import java.util.Set;

/**
 * RulesManager
 * 
 * @author <a href="mailto:vanto@users.berlios.de">Tammo van Lessen</a>
 * @version $id$
 */
public class RulesManager {

	private static RulesManager singleton = new RulesManager();

	private Set rules = new HashSet();
	
	/**
	 * TODO RulesManager 
	 */
	private RulesManager() {
	}

	public static RulesManager getInstance() {
		return singleton;
	}
	
	public void registerRule(AbstractRule rule) {
		rules.add(rule);
	}
	
	public void deregisterRule(AbstractRule rule) {
		rules.remove(rule);
	}
	
	/**
	 * returns true, if object is successfully validated
	 * by all registered rules.
	 * 
	 * @param object
	 * @return
	 */
	public boolean check(Checkable object) {
		if (rules.isEmpty()) {
			return true;
		}
		AbstractRule[] rls = (AbstractRule[])rules.toArray();
		for (int i = 0; i < rls.length; i++) {
			if (rls[i].canCheck(object)) {
				if (!rls[i].check(object)) {
					return false;		
				}
			}
		}
		
		return true;
	}
}

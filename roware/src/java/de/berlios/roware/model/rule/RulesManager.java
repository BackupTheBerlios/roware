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

import java.util.HashMap;
import java.util.Map;

/**
 * RulesManager
 * 
 * @author <a href="mailto:vanto@users.berlios.de">Tammo van Lessen</a>
 * @version $id$
 */
public class RulesManager {

	private static RulesManager singleton = new RulesManager();

	private Map rules = new HashMap();
	
	/**
	 * TODO RulesManager
	 * 
	 * TODO Implement Lazy Init for Rules
	 * TODO Implement Ruleseach for Strings without packagenames 
	 */
	private RulesManager() {
	}

	public static RulesManager getInstance() {
		return singleton;
	}
	
	public void registerRule(AbstractRule rule) {
		rules.put(rule.getClass().getName(), rule);
	}
	
	public void deregisterRule(AbstractRule rule) {
		rules.remove(rule.getClass().getName());
	}
	
	public AbstractRule getRuleByName(String name) {
		return (AbstractRule) rules.get(name);
	}
	
	/**
	 * returns true, if object is successfully validated
	 * by all registered rules.
	 * 
	 * @param object
	 * @return
	 */
	public void checkAll(Checkable object) throws RuleViolationException {
		if (rules.isEmpty()) {
			return;
		}
		AbstractRule[] rls = (AbstractRule[])rules.values().toArray();
		for (int i = 0; i < rls.length; i++) {
			if (rls[i].canCheck(object)) {
				rls[i].check(object);
			}
		}
		
		return;
	}
	
	public void check(Checkable object, String rule) throws RuleViolationException {
		AbstractRule rl = (AbstractRule) rules.get(rule);
		rl.check(object);
	}
}

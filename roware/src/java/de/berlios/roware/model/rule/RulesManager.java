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
 * @author Tammo van Lessen
 * @version $id: $
 */
public class RulesManager {

	private static RulesManager singleton = new RulesManager();

	private Map rules = new HashMap();
	private Map rulePool = new HashMap();
	
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
	
	public void registerRule(Class rule) throws Exception {
		if (AbstractRule.class.isAssignableFrom(rule)) {
			rules.put(rule.getName(), rule);
		} 
		else throw new Exception("Class is not a Rule");
	}
	
	public void deregisterRule(Class rule) {
		rules.remove(rule.getName());
	}
	
	public AbstractRule getRuleByName(String name) throws RuleNotFoundException {
		AbstractRule rule = (AbstractRule)rulePool.get(name);
		// lazy init
		if (rule == null) {
			Class ruleClass = (Class)rules.get(name);
			if (ruleClass == null) {
				throw new RuleNotFoundException(name);
			} else {
				try {
					rule = (AbstractRule)ruleClass.newInstance();
					rulePool.put(ruleClass.getName(), rule);
					return rule;
				} catch (InstantiationException e) {
					throw new RuleNotFoundException(name, e);
				} catch (IllegalAccessException e) {
					throw new RuleNotFoundException(name, e);
				}
			}
		} else	return rule;
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
			rls[i].check(object);
		}
		
		return;
	}
	
	public void check(Checkable object, String rule) throws RuleViolationException, RuleNotFoundException {
		AbstractRule rl = getRuleByName(rule);
		if (rl.canCheck(object)) {
			rl.check(object);	
		}		
	}
}

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

import de.berlios.roware.i18n.I18n;

/**
 * RuleNotFoundException
 * 
 * @author Tammo van Lessen
 * @version $id: $
 */
public class RuleNotFoundException extends Exception {

	/**
	 * @param rule rules name
	 */
	public RuleNotFoundException(String rule) {
		super(I18n.tr("Rule {0} is not registered", rule));
	}

	/**
	 * @param rule rules name
	 * @param e cause
	 */
	public RuleNotFoundException(String rule, Exception e) {
		super(I18n.tr("Rule {0} is not registered", rule),e);
	}

}

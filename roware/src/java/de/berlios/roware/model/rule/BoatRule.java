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

import de.berlios.roware.Roware;
import de.berlios.roware.model.Boat;

/**
 * BoatRule
 * 
 * @author <a href="mailto:vanto@users.berlios.de">Tammo van Lessen</a>
 * @version $id$
 */
public class BoatRule extends AbstractRule {

	/**
	 * 
	 */
	public BoatRule() {
	}

	/**
	 * @see de.berlios.roware.model.rule.AbstractRule#getTesteeClasses()
	 */
	public Class[] getCheckableClasses() {
		return new Class[] {Boat.class};
	}

	/**
	 * @see de.berlios.roware.model.rule.AbstractRule#check(de.berlios.roware.model.rule.Checkable)
	 */
	public void check(Checkable obj) throws RuleViolationException {
		// TODO This is just an example!
		String msg = null; 
		if (obj instanceof Boat) {
			Boat boat = (Boat)obj;
			if ((boat.getType() == Boat.SINGLE_SCULLS)
				&& (boat.getAthletes().length) != 1) {
				msg = Roware.tr("In einem Einer muss genau eine Person sitzen");
			} else if ((boat.getType() == Boat.DOUBLE_SCULLS)
						&& (boat.getAthletes().length) != 2) {
				msg = Roware.tr("In einem Zweier müssen genau 2 Person sitzen");
			} else if ((boat.getType() == Boat.QUADRUPPLE_SCULLS)
						&& (boat.getAthletes().length) != 4) {
				msg = Roware.tr("In einem Vierer müssen genau 4 Person sitzen");
			} else if ((boat.getType() == Boat.PAIRS)
						&& (boat.getAthletes().length) != 2) {
				msg = Roware.tr("In einem Zweier müssen genau 2 Person sitzen");
			} else if ((boat.getType() == Boat.FOURS)
						&& (boat.getAthletes().length) != 4) {
				msg = Roware.tr("In einem Vierer müssen genau 4 Person sitzen");
			} else if ((boat.getType() == Boat.EIGHTS)
						&& (boat.getAthletes().length) != 8) {
				msg = Roware.tr("In einem Achter müssen genau 8 Person sitzen");
			}
			
			if (msg != null) {
				throw new RuleViolationException(this, msg); 
			}
		}
	}

}

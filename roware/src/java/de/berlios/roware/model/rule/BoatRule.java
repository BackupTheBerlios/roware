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
	public boolean check(Checkable obj) {
		// TODO This is just an example!
		if (obj instanceof Boat) {
			Boat boat = (Boat)obj;
			return
					((boat.getType() == Boat.SINGLE_SCULLS)
					&& (boat.getAthletes().length) == 1)
				||
					((boat.getType() == Boat.DOUBLE_SCULLS)
					&& (boat.getAthletes().length) == 2)
				||					
					((boat.getType() == Boat.QUADRUPPLE_SCULLS)
					&& (boat.getAthletes().length) == 4)
				||
					((boat.getType() == Boat.PAIRS)
					&& (boat.getAthletes().length) == 2)
				||	
					((boat.getType() == Boat.FOURS)
					&& (boat.getAthletes().length) == 4)
				||	
					((boat.getType() == Boat.EIGHTS)
					&& (boat.getAthletes().length) == 8);
			
		} else {
			return true;
		}
	}

}

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

/**
 * Club - The Superclass for anythiong Persons may belong to. This may be a Rowing Club, a Organization specialized in doing Races,
 * a National Federation (like the German DRV) or something the like
 * 
 * @author Tammo van Lessen
 * @version $id: $
 */
public class Club extends AbstractPerson {

	private Club club;
	private String shortName;
	private String City;
	

	/**
	 * TODO Club
	 */
	public Club() {
	}

	/**
	 * @return
	 */
	public String getCity() {
		return City;
	}

	/**
	 * @return
	 */
	public Club getClub() {
		return club;
	}

	/**
	 * @return
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param string
	 */
	public void setCity(String string) {
		City = string;
	}

	/**
	 * @param club
	 */
	public void setClub(Club club) {
		this.club = club;
	}

	/**
	 * @param string
	 */
	public void setShortName(String string) {
		shortName = string;
	}

}

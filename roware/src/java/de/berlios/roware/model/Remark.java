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

import java.util.Date;

/**
 * Remark.java
 * This class manages any type of Remark one could do within the Process.
 * E.g. a Regatta Object could bear a number of Remarks specifying things you
 * could not place within a formal Invitation
 * 
 * @author Joachim Praetorius
 */
public class Remark {

	public static final int TYPE_GENERAL = 1;
	
	private String author = null;
	private String text = null;
	private int type ;
	private Date timestamp;
	
	public Remark(String author,String text){
		this.author = author;
		this.text = text;
		type = TYPE_GENERAL;
		timestamp = new Date();
	}

	public Remark(String author, String text, int type){
		this.author = author;
		this.text = text;
		this.type = type;
		timestamp = new Date();
	}

	/**
	 * Returns the author.
	 * @return String
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Returns the text.
	 * @return String
	 */
	public String getText() {
		return text;
	}

	/**
	 * Returns the timestamp.
	 * @return Date
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Returns the type.
	 * @return int
	 */
	public int getType() {
		return type;
	}

	/**
	 * Sets the author.
	 * @param author The author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Sets the text.
	 * @param text The text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Sets the timestamp.
	 * @param timestamp The timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Sets the type.
	 * @param type The type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

}

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
 * AbstractPerson
 * Generic Person Object. Base Class for all Persons handled within Roware. 
 * These are specified by Subclasses of this Object.
 * 
 * @author Tammo van Lessen
 * @version $id: $
 */
public abstract class AbstractPerson {

	private String name;
	private String firstName;
	private Address address;

	/**
	 * Empty constructor for the AbstractPerson
	 */
	public AbstractPerson() {
		name = null;
		firstName = null;
		address = null;
	}

	/**
	 * Constructor
	 * @param FullName the Full Name (i.e. First Name and Last Name) of the Person. This String is divided automagically
	 * @see #setFullName(String)
	 */
	public AbstractPerson(String FullName){
		address = null;
		setFullName(FullName);
	}
	
	/**
	 * Constructor
	 * @param FullName the Full Name (i.e. First Name and Last Name) of the Person. This String is divided automagically
	 * @param Address The Address of the Person
	 * @see #setFullName(String)
	 * @see Address
	 */
	public AbstractPerson(String FullName, Address Address){
		this.address = Address;
		setFullName(FullName);
	}
	
	/**
	 * Constructor
	 * @param Name the Last Name of the Person
	 * @param FirstName the First Name of the Person
	 */
	public AbstractPerson(String Name, String FirstName){
		this.name = Name;
		this.firstName = FirstName;
	}
	
	/**
	 * Constructor
	 * @param Name the Last Name of the Person
	 * @param FirstName the First Name of the Person
	 * @param Address the Address of the Person
	 * @see Address
	 */
	public AbstractPerson(String Name, String FirstName, Address Address){
		this.address = Address;
		this.name = Name;
		this.firstName = FirstName;
	}

	/**
	 * @return The Adress of the Person.
	 * @see Address
	 */
	public Address getAdress() {
		return address;
	}

	/**
	 * @return The First Name of the Person
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return The Last Name of the Person
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param address The Adress of the Person
	 * @see Address
	 */
	public void setAdress(Address address) {
		this.address = address;
	}

	/**
	 * @param string The First Name of the Person
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string The Last Name of the Person
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * Convenience Method, if only a Full String containing the First and the Last Name is provided. 
	 * This String is then separated at the <b>first blank</b> and the two Parts are assigned to FirstName and Name repectively
	 * @param name The Full Name of the person
	  */
	public void setFullName(String name){
		int split = name.indexOf(" ");
		firstName = name.substring(0,split);
		name = name.substring(split+1,name.length());
	}

	

}

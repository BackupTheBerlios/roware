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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * AbstractPerson
 * Generic Person Object. Base Class for all Persons handled within Roware. 
 * These are specified by Subclasses of this Object.
 * 
 * @author Tammo van Lessen
 * @version $id: $
 */
public abstract class AbstractPerson {

	private String name = null;
	private String firstName = null;
	private List address = new ArrayList();

	/**
	 * Empty constructor for the AbstractPerson
	 */
	public AbstractPerson() {
	
	}

	/**
	 * Constructor
	 * @param FullName the Full Name (i.e. First Name and Last Name) of the Person. This String is divided automagically
	 * @see #setFullName(String)
	 */
	public AbstractPerson(String FullName){
		setFullName(FullName);
	}
	
	/**
	 * Constructor
	 * @param FullName the Full Name (i.e. First Name and Last Name) of the Person. This String is divided automagically
	 * @param Address The Address of the Person
	 * @see #setFullName(String)
	 * @see Address
	 */
	public AbstractPerson(String FullName, Address address){
		addAddress(address);
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
	public AbstractPerson(String name, String firstName, Address address){
		addAddress(address);
		this.name = name;
		this.firstName = firstName;
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
		this.firstName = name.substring(0,split);
		this.name = name.substring(split+1,name.length());
	}

	/**
	 * Adds an Address to the Person
	 * @param address The Address to add to this Person
	 */
	public void addAddress(Address address) {
		this.address.add(address);
	}
	
	/**
	 * Returns all Addresses known for this Person
	 * @return
	 */
	public Object[] getAllAddresses(){
		return address.toArray();
	}
	
	/**
	 * Returns all known Addresses of a given Type. These Types are defined in the Class Address
	 * @param type The Type of Addresses to return. This may be one of the Types defined in de.berlios.roware.model.Address
	 * @return a List of the Addresses belonging to the given Type, an empty List if no Addresses of the given Type are known
	 * @see de.berlios.roware.model.Address
	 * @see java.util.list
	 */
	public List getAddressByType(int type){
		List result = new ArrayList();
	 	Iterator it = address.iterator();
		Address a;
		while(it.hasNext()){
			a = (Address)it.next();
			if (a.getType() == type){
				result.add(a);
			}
		}//while
		return result;
	}

	/**
 	* @see java.lang.Object#equals(java.lang.Object)
 	*/
	public boolean equals(Object obj) {
		if (obj instanceof AbstractPerson){
			AbstractPerson other = (AbstractPerson) obj;
			return (firstName.equals(other.getFirstName()) && name.equals(other.getName()));
		}else{
			return false;
		}
	}


}

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
 * Models an Address any Individual can have. It's possible to attach a 'type' to the different fields so it's possible to distinguish between private and Work Adresses
 * 
 * @author Tammo van Lessen
 * @version $id: $
 */
public class Address {

	//Descriptors
	public static final int TYPE_WORK = 1;
	public static final int TYPE_PRIVATE = 2;
	public static final int PHONE_OFFICE = 3;
	public static final int PHONE_PRIVATE = 4;
	public static final int PHONE_MOBILE = 5;
	public static final int EMAIL_OFFICE = 6;
	public static final int EMAIL_PRIVATE = 7;

	//Data Members
	private String street = null;
	private String zip = null;
	private String city = null;
	private String country = null;
	private List phoneNumbers = new ArrayList();
	private List emailAdresses = new ArrayList();
	private int type = 0;
	private int phoneType = 0;
	private int emailType = 0;

	/**
	 *Address Constructor
	 */
	public Address() {}

	/**
	 * Constructor for an Address with Snail-Mail Data
	 * @param street The Street of the Address
	 * @param zip The Postal-Code of the Address
	 * @param city The City of the Address
	 * @param type The Type of the Address, as defined in Address.
	 * TODO Maybe we should use regexps throughout this Object for sanity?
	 */
	public Address(String street, String zip, String city, int type) {
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.type = type;
	}

	/**
	 * Constructor for an Address with Snail-Mail and Phone Data
	 * @param street The Street of the Address
	 * @param zip The Postal-Code of the Address
	 * @param city The City of the Address
	 * @param type The Type of the Address, as defined in Address.
	 * @param phone The Phone Number
	 * @param phoneType the Type of the PhoneNumber
	 */
	public Address(
		String street,
		String zip,
		String city,
		int type,
		String phone,
		int phoneType) {
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.type = type;
		addPhoneNumber(new PhoneNumber(phone, phoneType));
	}

	/**
	 * Constructor for an Address with complete Data (i.e. Snail-Mail, Phone and E-Mail)
	 *@param street The Street of the Address
	 * @param zip The Postal-Code of the Address
	 * @param city The City of the Address
	 * @param type The Type of the Address, as defined in Address.
	 * @param phone The Phone Number
	 * @param phoneType the Type of the PhoneNumber
	 * @param email The E-Mail Address
	 * @param emailType the Type of the E-Mail-Address
	 */
	public Address(
		String street,
		String zip,
		String city,
		int type,
		String phone,
		int phoneType,
		String email,
		int emailType) {
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.type = type;
		addPhoneNumber(new PhoneNumber(phone, phoneType));
		addEMailAddress(new EMail(email, emailType));
	}

	/**
	 * @return The City
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return The Country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return The Type of the E-Mail Address
	 */
	public int getEmailType() {
		return emailType;
	}

	/**
	 * @return The Type of the Phone Number
	 */
	public int getPhoneType() {
		return phoneType;
	}

	/**
	 * @return The Street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return The Type of the Snail-Mail Adress, i.e. Street, Zip, City and Country optionally
	 */
	public int getType() {
		return type;
	}

	/**
	 * @return The Postal Code
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param string The Name of the City (e.g. "Berlin")
	 */
	public void setCity(String string) {
		city = string;
	}

	/**
	 * @param string The Name of the Country (e.g. "Germany")
	 */
	public void setCountry(String string) {
		country = string;
	}

	/**
	 * @param i the Type of the E-Mail-Address (may be one of EMAIL_OFFICE or EMAIL_PRIVATE)
	 */
	public void setEmailType(int i) {
		emailType = i;
	}

	/**
	 * @param i the Type of the Phone Number (may be one of PHONE_OFFICE, PHONE_MOBILE or PHONE_PRIVATE)
	 */
	public void setPhoneType(int i) {
		phoneType = i;
	}

	/**
	 * @param string the Name of the Street (e.g. "Hauptstraße")
	 */
	public void setStreet(String string) {
		street = string;
	}

	/**
	 * @param i he Type of the Snail-Mail-Address (may be one of TYPE_WORK or TYPE_PRIVATE)
	 */
	public void setType(int i) {
		type = i;
	}

	/**
	 * @param string The Postal Code (e.g. "12161")
	 */
	public void setZip(String string) {
		zip = string;
	}

	/**
	 * Method addPhoneNumber.
	 * @param phone
	 * @param phoneType
	 */
	public void addPhoneNumber(PhoneNumber p) {
		phoneNumbers.add(p);
	}

	/**
	 * Method addEmailAddress
	 * @param email An EMailAddress
	 * */
	public void addEMailAddress(EMail e) {
		emailAdresses.add(e);
	}

	/**
	 * Returns all EMail Addresses assigned to this Address..
	 * @return List
	 */
	public List getEMailAdresses() {
		return emailAdresses;
	}

	/**
	 * Returns all EMail Addreses of Type <code>type</code> 
	 * If no such EMail Addresses are stored in this Address the returned List
	 * is empty
	 * @param type The Type of EMail Addresses to search for
	 * @return List
	 */
	public List getEMailAdresses(int type) {
		List result = new ArrayList();
		Iterator it = emailAdresses.iterator();
		EMail e;
		while (it.hasNext()) {
			e = (EMail) it.next();
			if (e.getType() == type) {
				result.add(e);
			}
		} //while
		return result;
	} //getEMByType

	public List getPhoneNumbers() {
		return phoneNumbers;
	}

	public List getPhoneNumbers(int type) {
		List result = new ArrayList();
		Iterator it = emailAdresses.iterator();
		PhoneNumber p;
		while (it.hasNext()) {
			p = (PhoneNumber) it.next();
			if (p.getType() == type) {
				result.add(p);
			}
		} //while
		return result;
	}

}

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
 package de.berlios.roware.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * I18n
 * 
 * @author <a href="mailto:vanto@users.berlios.de">Tammo van Lessen</a>
 * @version $id$
 */
public class I18n {

	/**
	 * This list contains all languages the Roware has been
	 * translated into. Add new languages here (see TRANSLATION file).
	 */
	public static final Locale[] LANGUAGES = {
			/*Locale.ENGLISH,*/ Locale.GERMAN, 
			};
	
	/**
	 * Reference to the current localization bundle.
	 */
	private static ResourceBundle resources;

	/**
	 * Sets default locale and loads resources.
	 */
	public static void initLocale(String language)
	{
		for (int i = 0; i < LANGUAGES.length; i++) {
			if (language.equals(LANGUAGES[i].getLanguage())) {
				Locale.setDefault(LANGUAGES[i]);
				break;
			}
		}

		try {
			resources = ResourceBundle.getBundle("de.berlios.roware.i18n.roware",
												 Locale.getDefault());
		}
		catch (MissingResourceException e) {
			System.err.println("resources/roware.properties not found");
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
	
	/**
	 * Returns the currently used message bundle.
	 */
	public static final ResourceBundle getMessagesBundle()
	{
		return resources;
	}

	/**
	 * Returns <code>text</code> translated into the currently selected
	 * language. Every user-visible string in the program must be wrapped
	 * into this function.  
	 */
	public static final String tr(String text)
	{
		try {
			return getMessagesBundle().getString(text);
		}
		catch (MissingResourceException e) {
			//System.err.println("missing translation key: \"" + text + "\"");
			//e.printStackTrace(System.err);
			return text;
		}
		catch (NullPointerException e) {
			// the message bundle has not been loaded yet
			return text;
		}
	}

	/**
	 * Returns <code>text</code> translated into the currently selected
	 * language. 
	 *
	 * <p>The first occurence of {0} is replaced by <code>o1.toString()</code>.
	 */
	public static final String tr(String text, Object o1)
	{
		return MessageFormat.format(I18n.tr(text), new Object[] { o1 });
	}

	/**
	 * Returns <code>text</code> translated into the currently selected
	 * language. 
	 *
	 * <p>The first occurence of {0} is replaced by <code>o1.toString()</code>.
	 * The first occurence of {1} is replaced by <code>o2.toString()</code>.
	 */
	public static final String tr(String text, Object o1, Object o2)
	{
		return MessageFormat.format(I18n.tr(text), new Object[] { o1, o2 });
	}

	/**
	 * Returns <code>text</code> translated into the currently selected
	 * language. 
	 *
	 * <p>The first occurence of {0} is replaced by <code>o1.toString()</code>.
	 * The first occurence of {1} is replaced by <code>o2.toString()</code>.
	 * The first occurence of {2} is replaced by <code>o3.toString()</code>.
	 */
	public static final String tr(String text, Object o1, Object o2,
								  Object o3)
	{
		return MessageFormat.format(I18n.tr(text), 
									new Object[] { o1, o2, o3 });
	}

	/**
	 * Returns <code>text</code> translated into the currently selected
	 * language. Prepends and appends <code>padding</code> whitespaces.
	 */
	public static final String tr(String text, int padding)
	{
		String s = tr(text);
		if (padding <= 0) {
			return s;
		}
		StringBuffer sb = new StringBuffer(s.length() + padding * 2);
		append(sb, " ", padding);
		sb.append(s);
		append(sb, " ", padding);
		return sb.toString();
	}

	/**
	 * Returns <code>text</code> translated into the currently selected
	 * language. Prepends <code>lpadding</code> whitespaces. Appends
	 * <code>rpadding</code> whitespaces.
	 */
	public static final String tr(String text, int lpadding, int rpadding)
	{
		String s = tr(text);
		StringBuffer sb = new StringBuffer(s.length() + lpadding + rpadding);
		append(sb, " ", lpadding);
		sb.append(s);
		append(sb, " ", rpadding);
		return sb.toString();
	}

	private static final void append(StringBuffer sb, String s, int count)
	{
		for (int i = 0; i < count; i++) {
			sb.append(s);
		}
	}

}

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
package de.berlios.roware;

import net.sf.hibernate.HibernateException;
import de.berlios.roware.i18n.I18n;
import de.berlios.roware.model.Athlete;
import de.berlios.roware.model.ModelDAO;
import de.berlios.roware.model.Team;


/**
 * Roware
 * 
 * @author Tammo van Lessen
 * @version $Id: Roware.java,v 1.4 2003/07/10 22:29:34 vanto Exp $
 */
public class Roware {


	/**
	 * 
	 */
	public Roware() {
	}

	public static void init() {
		I18n.initLocale("de");
	}
	
	public static void main(String[] args) {
		init();
		System.out.println(I18n.tr("starting roware")+"...");
		ModelDAO mdao = new ModelDAO();
		// test o/r
		Athlete a = new Athlete();
		a.setCoach(false);
		a.setWeight(7200);
		a.setName("Willi Wuchter");
		Athlete b = new Athlete();
		b.setCoach(false);
		b.setWeight(7200);
		b.setName("Willi Wuchter");
		Athlete c = new Athlete();
		c.setCoach(false);
		c.setWeight(7200);
		c.setName("Willi Wuchter");
		Athlete d = new Athlete();
		d.setCoach(false);
		d.setWeight(7200);
		d.setName("Willi Wuchter");

		Team t1 = new Team();
		t1.getAthletes().add(a);
		t1.getAthletes().add(b);

		Team t2 = new Team();
		t2.getAthletes().add(a);
		t2.getAthletes().add(c);

		Team t3 = new Team();
		t3.getAthletes().add(a);
		t3.getAthletes().add(b);
		t3.getAthletes().add(c);
		t3.getAthletes().add(d);

		try {
			mdao.addParticipant(a);
			mdao.addParticipant(b);
			mdao.addParticipant(c);
			mdao.addParticipant(d);
			mdao.addTeam(t1);
			mdao.addTeam(t2);
			mdao.addTeam(t3);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
}

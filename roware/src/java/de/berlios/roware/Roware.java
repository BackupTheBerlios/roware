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
 * @version $Id: Roware.java,v 1.5 2003/07/15 16:02:40 jpraetorius Exp $
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
		a.setWeight(7200);
		a.setName("Willi Wuchter");
		Athlete b = new Athlete();
		b.setWeight(7200);
		b.setName("Willi Wuchter");
		Athlete c = new Athlete();
		c.setWeight(7200);
		c.setName("Willi Wuchter");
		Athlete d = new Athlete();
		d.setWeight(7200);
		d.setName("Willi Wuchter");

		Team t1 = new Team();
		t1.addAthlete(a);
		t1.addAthlete(b);

		Team t2 = new Team();
		t2.addAthlete(a);
		t2.addAthlete(c);

		Team t3 = new Team();
		t3.addAthlete(a);
		t3.addAthlete(b);
		t3.addAthlete(c);
		t3.addAthlete(d);

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

/*
 * roware
 * TODO
 * Created on 02.07.2003
 *
 */
package de.berlios.roware.model;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.MappingException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

/**
 * ModelDAO
 * 
 * @author Tammo van Lessen
 * @version $id: $
 */
public class ModelDAO {

	private Configuration cfg;
	private Session sess;
	
	public ModelDAO() {

		
		try {
			cfg = new Configuration()
						.addClass(Participant.class)
						.addClass(Team.class);

			SessionFactory sessions = cfg.buildSessionFactory();
			sess = sessions.openSession();
		} catch (MappingException e) {
			throw new RuntimeException("couldn't create o/r mapping", e);
		} catch (HibernateException e) {
			throw new RuntimeException("couldn't get connection", e);
		}
	}
	
	public void addParticipant(Participant a) throws HibernateException {
		sess.save(a);
		sess.flush();
	}
	
	public void removeParticipant(Participant a) throws HibernateException {
		sess.delete(a);
		sess.flush();
	}

	public void addTeam(Team t) throws HibernateException {
		sess.save(t);
		sess.flush();
	}
	
	public void removeTeam(Team t) throws HibernateException {
		sess.delete(t);
		sess.flush();
	}

}
